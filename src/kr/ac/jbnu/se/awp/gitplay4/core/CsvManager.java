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
		// 업로드 경로
		String uploadPath = BASE_DIR + UPLOAD_DIR;
		
		String fileName = "";
		try {
			for (Part part : req.getParts()) { // req.getParts() : Multipart데이터들을 Part객체로 리턴
				fileName = getFileName(part); // 파일명을 가져와주는 메소드 실행
				System.out.println(fileName);
				System.out.println(part.getHeader("content-disposition")); // part마다 header 있음
				if (fileName != null && !"".equals(fileName)) { // !폼필드경우 && !파일아예업로드 안했을 때
					makeDir(uploadPath);
					part.write(uploadPath + File.separator + fileName); // 파일 저장
					System.out.println("파일명 : " + fileName + "저장완료!!!");
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
		return null; // filename이 없는 경우 (폼필드 데이터인 경우):
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
