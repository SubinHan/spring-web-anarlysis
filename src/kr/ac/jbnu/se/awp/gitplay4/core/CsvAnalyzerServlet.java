package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.awp.gitplay4.core.r.BarChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.core.r.BoxChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.core.r.ChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.core.r.ChartGeneratorBuilderFactory;
import kr.ac.jbnu.se.awp.gitplay4.core.r.HistogramChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.core.r.LineChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.model.ChartType;

@WebServlet(name = "DynamicFormExServlet", urlPatterns = { "/DynamicFormExServlet" })
public class CsvAnalyzerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		String path, chartName, xAxis, yAxis, saveDirectoryPath;
		double ymax, ymin;
		path = FileManager.getRecentCsv(id).getPath();
		chartName = req.getParameter("chartName");
		xAxis = req.getParameter("xAxis");
		yAxis = req.getParameter("yAxis");
		saveDirectoryPath = FileManager.getChartFolderPath(id);
		ymax= Double.parseDouble(req.getParameter("ymax"));
		ymin = Double.parseDouble( req.getParameter("ymin"));
		
		ChartGeneratorBuilder builder = ChartGeneratorBuilderFactory.createBuilder(ChartType.BAR);
		ChartGenerator generator = builder.csvPath(path).chartName(chartName).yRangeMax(ymax).yRangeMin(ymin).outputPath(saveDirectoryPath).xName(xAxis).yName(yAxis).build();
		
		generator.generate();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/jsp/test_extract_image.jsp").forward(req, resp);
	}

}
