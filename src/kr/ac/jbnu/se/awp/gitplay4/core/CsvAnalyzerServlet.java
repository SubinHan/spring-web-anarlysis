package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DynamicFormExServlet", urlPatterns = { "/DynamicFormExServlet" })
public class CsvAnalyzerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String path, xAxis, yAxis, saveDirectoryPath;
		path = FileManager.getRecentCsv(FileManager.getUserIP(req)).getPath();
		xAxis = req.getParameter("xAxis");
		yAxis = req.getParameter("yAxis");
		saveDirectoryPath = FileManager.getChartFolderPath(FileManager.getUserIP(req));
		
		LineGenerator generator = new LineGenerator(path, xAxis, yAxis, saveDirectoryPath);
		generator.makeLine();
		
		this.getServletContext().getRequestDispatcher("/test_extract_image.jsp").forward(req, resp);
	}

}
