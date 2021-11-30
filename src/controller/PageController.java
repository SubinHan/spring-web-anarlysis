package controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.jbnu.se.awp.gitplay4.core.FileManager;
import kr.ac.jbnu.se.awp.gitplay4.core.UserManager;
import kr.ac.jbnu.se.awp.gitplay4.model.Login;

@Controller
public class PageController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "login";
	}
	
	@RequestMapping(value="registration", method =RequestMethod.GET) 
	public String registration() {
		 return "registration";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(@ModelAttribute Login login) {
		String id = login.getId();
		String password = login.getPassword();

		UserManager manager = UserManager.getInstance();

		if (manager.isValid(id, password)) {
			HttpSession session = session();
			session.setAttribute("id", id);
			session.setAttribute("password", password);

			System.out.println(session.getAttribute("id") + " " + session.getAttribute("password"));

		} else {
			System.out.println("Aa");
		}

		return "upload_form_new";
	}

	@RequestMapping(value = "configuration", method = RequestMethod.POST)
	public String configuration() {
		return "dynamicform";
	}
	
	@RequestMapping(value = "select", method = RequestMethod.POST)
	public String selectChart() {
		
		return "select_charttype";
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}
}
