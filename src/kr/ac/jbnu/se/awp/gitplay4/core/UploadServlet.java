package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name = "UploadServlet", urlPatterns = { "/UploadServlet" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class UploadServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CsvManager.addFile(getUserIP(req), req);
		
		System.out.println(CsvManager.getRecentFile(getUserIP(req)));
	} // doPost()


	private String getUserIP(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For"); //client's real ip
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {                    
		     ip = request.getHeader("Proxy-Client-IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("WL-Proxy-Client-IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("HTTP_CLIENT_IP");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		 
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
		     ip = request.getRemoteHost();
		}
		    return ip;
		}
} // class