package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
	
	@RequestMapping(value = "download/{id}", method = RequestMethod.GET)
	public void fileDownlad(@PathVariable(value = "id") String id, HttpServletResponse response) {
		
		System.out.println("aa" + id);
		File file = FileManager.getRecentChartFile(id);
		String filePath = file.getPath();
		String fileName = "Generated Chart.png";
		String contentType = "image/png";
		long fileLength = file.length();
		
		response.setHeader("Content-Disposition",  "attachment; filename=\"" + fileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary"); 
        response.setHeader("Content-Type", contentType);
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        // 그 정보들을 가지고 reponse의 Header에 세팅한 후
        
        try (FileInputStream fis = new FileInputStream(filePath); OutputStream out = response.getOutputStream();) {
            // saveFileName을 파라미터로 넣어 inputStream 객체를 만들고 
            // response에서 파일을 내보낼 OutputStream을 가져와서  
            int readCount = 0;
            byte[] buffer = new byte[1024];
            // 파일 읽을 만큼 크기의 buffer를 생성한 후 
            while ((readCount = fis.read(buffer)) != -1) {
                out.write(buffer, 0, readCount);
                // outputStream에 씌워준다
            }
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}

	public static HttpSession session() {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		return attr.getRequest().getSession(true); // true == allow create
	}
}