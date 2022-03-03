package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.StockService;
import pj.mvc.jsp.service.StockServiceImpl;
import pj.mvc.jsp.util.ImageUploaderHandler;

@WebServlet("*.st")
// 톰캣이 개발디렉토리 내용을 배포 디렉토리로 복사후 실행함, 평소 소스를 수정했는데 반영이 안된경우, 배포디렉토리로 카피가 늦어진 경우임.. 서비스 다시시작하거나, clean 해주는 이유이다.
// 톰캣배포 디렉토리 ㄱ : 실제로 서비스되는 디렉토리
// location = "C:\\apache-tomcat-8.5.73\\wtpwebapps\\jsp_pj_sch\\images\\";
@MultipartConfig(location="C:\\eclipse\\workspace\\jsp_pj_sch\\src\\main\\webapp\\resources\\images\\upload",
				 fileSizeThreshold=1024*1024,
				 maxFileSize=1024*1024*10,
				 maxRequestSize=1024*1024*10
				 )
public class StockController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private static final String IMG_UPLOAD_PATH = "C:\\apache-tomcat-8.5.73\\wtpwebapps\\jsp_pj_sch\\images\\"; 
	private static final String IMG_UPLOAD_PATH = "C:\\eclipse\\workspace\\jsp_pj_sch\\src\\main\\webapp\\resources\\images\\upload";
	
	StockService stockService;
	
	private ImageUploaderHandler uploader;
	
	public StockController() {
		this.stockService = new StockServiceImpl();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		action(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}

	public void action(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		
		String url = req.getServletPath();
		
		String viewPage = "";
		
		// 상품 리스트
		if (url.equals("/*.st") || url.equals("/stock_list.st")) {
			System.out.println("[/*.st 또는 /stock_list.st 진입]");
		
			stockService.stockList(req, res);
			
			viewPage = "/manager/stock/stock_list.jsp";	
		
		// 상품 추가 페이지
		} else if (url.equals("/stock_add.st")) {
			System.out.println("[/stock_list.st 진입]");
			
			viewPage = "/manager/stock/stock_add.jsp";	
		
		// 상품 추가 처리
		} else if (url.equals("/stock_add_action.st")) {
			System.out.println("[/stock_add_action.st 진입]");
			
			String contentType = req.getContentType();
			
			// multipart/form-data 가 있는 경우 이미지 파일 업로드 수행
			if (contentType != null & contentType.toLowerCase().startsWith("multipart/")) {
				uploader = new ImageUploaderHandler();
				uploader.setUploadUrl(IMG_UPLOAD_PATH);
				uploader.uploadImage(req, res);
			}
			
			stockService.stockAddAction(req, res);
			
			viewPage = "/manager/stock/stock_add_action.jsp";
		
		// 상품 상세
		} else if (url.equals("/stock_detail.st")) {
			System.out.println("[/stock_detail.st 진입]");
			
			stockService.stockDetail(req, res);
			
			viewPage = "/manager/stock/stock_detail.jsp";
			
		// 상품 수정
		} else if (url.equals("/stock_update_action.st")) {
			System.out.println("[/stock_update_action.st 진입]");
			
			String contentType = req.getContentType();
			if (contentType != null && contentType.toLowerCase().startsWith("/multipart")) {
				uploader = new ImageUploaderHandler();
				uploader.setUploadUrl(IMG_UPLOAD_PATH);
				uploader.uploadImage(req, res);
			}
			
			stockService.stockUpdateAction(req, res);
			
			viewPage = "/manager/stock/stock_update_action.jsp";
			
		// 상품 삭제
		} else if (url.equals("/stock_delete_action.st")) {
			System.out.println("[/stock_delete_action.st 진입]");
			
			stockService.stockDeleteAction(req, res);
			
			viewPage = "/manager/stock/stock_delete_action.jsp";
			
		}
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}