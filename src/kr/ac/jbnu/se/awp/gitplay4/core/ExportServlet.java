package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ExportServlet", urlPatterns = { "/ExportServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class ExportServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String fullpath = FileManager.getRecentChartFile((String)session.getAttribute("id")).getPath();
		
		File file = new File(fullpath);
		long length = file.length();
		resp.setContentType("application/octet-stream");
		resp.setContentLengthLong(length);
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		BufferedOutputStream bos = new BufferedOutputStream(resp.getOutputStream());
		
		int data;
		while((data=bis.read()) != 1) {
			bos.write(data);
			bos.flush();
		}
		bis.close();
		bos.close();
	}
	
}

