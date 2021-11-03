package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DynamicFormExServlet", urlPatterns = { "/DynamicFormExServlet" })
public class DynamicFormExServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("xAxis"));
		System.out.println(Arrays.toString(req.getParameterValues("yAxis")));
		
		this.getServletContext().getRequestDispatcher("/test_extract_image.jsp").forward(req, resp);
	}
	
	
	
}
