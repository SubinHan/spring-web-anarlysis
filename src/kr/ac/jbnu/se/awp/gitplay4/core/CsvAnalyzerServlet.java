package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.jbnu.se.awp.gitplay4.core.r.ChartGeneratorBuilder;
import kr.ac.jbnu.se.awp.gitplay4.core.r.LineChartGeneratorBuilder;

@WebServlet(name = "DynamicFormExServlet", urlPatterns = { "/DynamicFormExServlet" })
public class CsvAnalyzerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String id = (String) session.getAttribute("id");
		
		String path, xAxis, yAxis, saveDirectoryPath;
		path = FileManager.getRecentCsv(id).getPath();
		xAxis = req.getParameter("xAxis");
		yAxis = req.getParameter("yAxis");
		saveDirectoryPath = FileManager.getChartFolderPath(FileManager.getUserIP(req));
		
		ChartGeneratorBuilder builder = new LineChartGeneratorBuilder();
		ChartGenerator generator = builder.csvPath(path).outputPath(saveDirectoryPath).xName(xAxis).yName(yAxis).build();
		
		generator.generate();
		
		this.getServletContext().getRequestDispatcher("/test_extract_image.jsp").forward(req, resp);
	}

}
