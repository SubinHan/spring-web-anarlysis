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

@WebServlet(name="UploadServlet", urlPatterns = {"/UploadServlet"})
@MultipartConfig(fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class UploadServlet extends HttpServlet {
private static final String UPLOAD_DIR = "upload_files";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // ���ε� ���
    String uploadPath = getServletContext().getRealPath("") + File.separator + UPLOAD_DIR;
    // getServlet().getRealPath("") ����
    // - ���ø����̼� �����ϴٰ� ���� ������ clean�ϸ� ���ε������� �� ����
    // - �����η� �����ؼ� ���ε��ϴ°� ������
    // - ����, ������ ���� ��쿡�� �����θ� �����ؾ���.

    File uploadDir = new File(uploadPath);

    // ��� ������ mkdir�� ����
    if(!uploadDir.exists()) {
      uploadDir.mkdir();
    }

    try{
      String fileName = "";
      for(Part part : req.getParts()) { // req.getParts() : Multipart�����͵��� Part��ü�� ����
        System.out.println(part.getHeader("content-disposition")); // part���� header ����
        if(fileName != null && !"".equals(fileName)) { // !���ʵ��� && !���Ͼƿ����ε� ������ ��
          part.write(uploadPath + File.separator + fileName); // ���� ����
          System.out.println("���ϸ� : " + fileName + "����Ϸ�!!!");
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("�Ķ���� �� : " + req.getParameter("sender"));
    resp.setContentType("text/html");
    resp.getWriter().println("���ε� �Ϸ�...!!");
  } // doPost()

  /**
   * Param��ü �Ľ��Ͽ� �����̸� �����ϱ�
   * @param part
   * @return ���ϸ� : ���ϸ��� �������� ������ null (���ʵ� ������)
   */
  // ��� ����
  // form-data; name="multiPartServlet"; filename="git command.txt"
  private String getFileName(Part part) {
    for (String content : part.getHeader("content-disposition").split(";")) {
      if(content.trim().startsWith("filename")) {
        return content.substring(content.indexOf("=")+2, content.length()-1);
      }
    }
    return null; // filename�� ���� ��� (���ʵ� �������� ���):
  }
} // class