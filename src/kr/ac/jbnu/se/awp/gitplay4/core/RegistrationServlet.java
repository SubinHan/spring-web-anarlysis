package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistrationServlet", urlPatterns = { "/RegistrationServlet" })
public class RegistrationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		UserManager manager = UserManager.getInstance();
		
		manager.registerUser(id, password);
		
	
		PrintWriter writer = resp.getWriter();
		writer.println("<script>alert('Registering User Success!'); location.href=\"login.jsp\"; </script>");
		writer.close();
			
//			this.getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
		
	}

}
