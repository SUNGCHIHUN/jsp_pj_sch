package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.ManagerService;
import pj.mvc.jsp.service.ManagerServiceImpl;

@WebServlet("*.ad")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ManagerService service;
	
	public AdminController() {
		this.service = new ManagerServiceImpl();
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
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		String url = uri.substring(contextPath.length());

		// jsp 페이지 경로
		String viewPage = "";
		
		// 재고관리 페이지 이동
		if (url.equals("/*.ad") || url.equals("/stock_list.ad")) {
			System.out.println("[stock_list.ad] 진입");
		
			service.stockListAction(req, res);
			
			viewPage = "/manager/stock/stock_list.jsp";
			
		} else if (url.equals("/??.ad")) {

		}
		
		// jsp 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}