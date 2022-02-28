package pj.mvc.jsp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class ImageUploaderHandler {
	
	//  업로드 이미지 경로
	private String uploadPath;
	
	public ImageUploaderHandler() {}
	
	// 1. 업로드할 이미지의 경로 설정
	public void setUploadUrl(String url) {
		this.uploadPath = url;
	}

	// 2. 이미지 업로드
	public void uploadImage(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("uploadPath : " + uploadPath);
		
		
		File uploadDir = new File(uploadPath);
		
		// 디렉토리가 없으면 생성
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// 권한 설정
			uploadDir.setWritable(true);
			uploadDir.setReadable(true);
			uploadDir.setExecutable(true);
		
			String fileName = "";
			
			// multipart/form-data 방식으로 넘긴 데이터들을 확인
			for(Part part : req.getParts()) {
				fileName = getFileName(part);
				// 파일이 있으면
				if (fileName != null && !fileName.equals("")) {
					// 파일 쓰기
					part.write(uploadPath + File.separator + fileName);
					req.setAttribute("fileName", fileName);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		res.setContentType("text/html; charset=UTF-8");
		res.getWriter().println("=== 업로드 완료! ===");
	}
	
	// 파일이름 파싱해서 반환
	public String getFileName(Part part) {
		
		for (String content : part.getHeader("content-disposition").split(";")) {
			// filename 으로 시작하는 부분을 찾아서 반환
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=") + 2, content.length() - 1);
			}
		}
		// 파일 데이터가 없으면 null 반환
		return null;
	}
}