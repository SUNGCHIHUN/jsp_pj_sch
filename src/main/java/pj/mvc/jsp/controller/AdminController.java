package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.AdminService;
import pj.mvc.jsp.service.AdminServiceImpl;

@WebServlet("*.ad")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService service;
	
	public AdminController() {
		this.service = new AdminServiceImpl();
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
		
		// 주문관리 페이지 이동
		if (url.equals("/*.ad") || url.equals("/order_list.ad")) {
			System.out.println("[order_list.ad] 진입");
		
			service.orderList(req, res);
			
			viewPage = "/manager/order/order_list.jsp";
			
		// 주문 승인
		} else if (url.equals("/order_confirm_action.ad")) {
			System.out.println("[order_confirm_action.ad] 진입");
			
			service.orderConfirmAction(req, res);
			
			viewPage = "/manager/order/order_confirm_action.jsp";
			
		// 주문 취소
		} else if (url.equals("/order_cancel_action.ad")) {
			System.out.println("[order_cancel_action.ad] 진입");
			
			service.orderCancelAction(req, res);
			
			viewPage = "/manager/order/order_cancel_action.jsp";
			
		// 배송관리 페이지 이동
		} else if (url.equals("/delivery_list.ad")) {
		
			service.deliveryList(req, res);
			
			viewPage = "/manager/delivery/delivery_list.jsp";
			
		// 배송 시작
		} else if (url.equals("/delivery_start_action.ad")) {
			
			viewPage = "/manager/delivery/delivery_start_action.jsp";
		
		// 배송 완료
		} else if (url.equals("/delivery_end.ad")) {
			
			viewPage = "/manager/delivery/delivery_end_action.jsp";
		
		// 배송 상세조회
		} else if (url.equals("/delivery_detail.ad")) {
			
			viewPage = "/manager/delivery/delivery_detail.jsp";
			
		}
		
		// jsp 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}