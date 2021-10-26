package kr.ac.jbnu.se.awp.gitplay4.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class CsvManager {
	public static final String BASE_DIR = "C:/";

	public static void addFile(String id, HttpServletRequest req) {
		String UPLOAD_DIR = id;
		// ���ε� ���
		String uploadPath = BASE_DIR + UPLOAD_DIR;
		
		String fileName = "";
		try {
			for (Part part : req.getParts()) { // req.getParts() : Multipart�����͵��� Part��ü�� ����
				fileName = getFileName(part); // ���ϸ��� �������ִ� �޼ҵ� ����
				System.out.println(fileName);
				System.out.println(part.getHeader("content-disposition")); // part���� header ����
				if (fileName != null && !"".equals(fileName)) {
					makeDir(uploadPath);
					part.write(uploadPath + File.separator + fileName); 
				}

			}
		} catch (IOException | ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void makeDir(String uploadPath) {
		new File(uploadPath).mkdirs();
	}

	public static File getRecentFile(String id) {
		return getLastModified(BASE_DIR + id);
	}

	private static String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				String filename = content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
				return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
			}
		}
		return null; // filename�� ���� ��� (���ʵ� �������� ���):
	}
	
	public static File getLastModified(String directoryFilePath)
	{
	    File directory = new File(directoryFilePath);
	    File[] files = directory.listFiles(File::isFile);
	    long lastModifiedTime = Long.MIN_VALUE;
	    File chosenFile = null;

	    if (files != null)
	    {
	        for (File file : files)
	        {
	            if (file.lastModified() > lastModifiedTime)
	            {
	                chosenFile = file;
	                lastModifiedTime = file.lastModified();
	            }
	        }
	    }

	    return chosenFile;
	}
}
