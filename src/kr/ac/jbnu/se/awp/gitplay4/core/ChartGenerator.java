package kr.ac.jbnu.se.awp.gitplay4.core;

import java.util.ArrayList;
import java.util.List;

/*import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;*/
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;
//import javax.servlet.http.HttpServletRequest;



public class ChartGenerator {
	//this class is parent class of line, bar, ~ class
	//getting parameter, preprocessing
	
	//for using R, Rconnection is necessary. it is used like using other R server.
	RConnection connection = null;
	
	//to get parameter example, it will be changed to get parameter by other class
	//the number of necessary parameters is different between graphs
	protected  String downloadPath ="C:/Users/jimin/vscode-workspace/Web_with_R/userFile/";
	protected  String userIP = "3530916043";
	protected  String userfilename = "3530916043.csv";
	protected  String saveDirectoryPath;
	protected  String rfilePath= "\"" + downloadPath +"\"";
	protected  String imageTitle = "Temperature";
	protected  String imageName = imageTitle.concat(".png");
	protected  String x = "수집시간";
	protected  String y = "온도";
	protected  String xName = "Time";
	protected  String yName = "Temperature";
	protected  String outlierName = "온도";
	protected  String outlierRange_start = "30";
	protected  String outlierRange_end = "50";
	
	public ChartGenerator(String csvPath, String xAxis, String yAxis, String saveDirectoryPath) {
		this.downloadPath = csvPath.replace("\\", "/");
		this.rfilePath = "\"" + downloadPath +"\"";
		this.x = xAxis;
		this.y = yAxis;
		this.xName = xAxis;
		this.yName = yAxis;
		this.saveDirectoryPath = saveDirectoryPath.replace("\\", "/");
		this.saveDirectoryPath = "\"" + saveDirectoryPath + "\"";
		System.out.println(this.saveDirectoryPath);
	}
	

	
	//it also will be changed because of difference of the number of x,y parameters
	//maybe this method will have parameter like outlierName and Range
	public void preprocess() {
		
		try {
			connection = new RConnection();
			
			connection.eval("csv_data <- read.csv("+rfilePath +",header=TRUE)");
			connection.eval("csv_data <- subset(csv_data, "+outlierName+">"+outlierRange_start+" &"+outlierName+"<"+outlierRange_end+")");
			connection.eval("setwd(\""+downloadPath+"/"+userIP+"\")");
			connection.eval("write.csv(csv_data, file = \""+userfilename+"\", row.names=FALSE)");
			
			System.out.println("Preprocessing clear");
			
		} catch (RserveException e) {
			e.printStackTrace();
		} 
		finally {
			connection.close();
		}
	}
}

