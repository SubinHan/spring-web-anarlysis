package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

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
		
		if(manager.isValid(id, password)) {
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			
			System.out.println(session.getAttribute("id") + " " + session.getAttribute("password"));
			this.getServletContext().getRequestDispatcher("/upload.jsp").forward(req, resp);

		}
		else {
			System.out.println("Aa");
		}
	}

}
