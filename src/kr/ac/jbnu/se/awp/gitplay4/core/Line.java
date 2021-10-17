package kr.ac.jbnu.se.awp.gitplay4.core;
import java.util.ArrayList;
import java.util.List;

/*import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;*/
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
//import javax.servlet.http.HttpServletRequest;

public class Line extends ChartGenerator{
	
	public void makeLine() {

		try {
			connection = new RConnection();
	
			connection.eval("csv_data <- read.csv("+rfilePath +",header=TRUE)");
			
			
			connection.eval("library(ggplot2)");
			connection.eval("library(dplyr)");
			
			connection.eval("a<-csv_data%>% ggplot(aes("+x+", "+y+", group=1))"
					+ "+ geom_line(color = 'coral')"
					+ "+ ggtitle(\""+imageTitle+"\")"
					+ "+ xlab(\""+xName+"\")+ylab(\""+yName+"\")"
					+ "+ theme_light()"
					+ "+ theme(plot.title = element_text(size=20, hjust=0.5))");
			connection.eval("ggsave(filename=\""+imageName+"\", plot=a, width=12,height=6)");
			
			System.out.println(imageName + " Line Making Clear");

		} catch (RserveException e) {
			e.printStackTrace();
		}  
		finally {
			connection.close();
		}
	}
}
