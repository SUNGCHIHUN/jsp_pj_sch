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
import pj.mvc.jsp.service.BoardService;
import pj.mvc.jsp.service.BoardServiceImpl;
import pj.mvc.jsp.service.ReviewService;
import pj.mvc.jsp.service.ReviewServiceImpl;

@WebServlet("*.ad")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdminService adminService;
	BoardService boardService;
	ReviewService reviewService;
	
	public AdminController() {
		this.adminService = new AdminServiceImpl();
		this.boardService = new BoardServiceImpl();
		this.reviewService = new ReviewServiceImpl();
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
		
			adminService.orderList(req, res);
			
			viewPage = "/manager/order/order_list.jsp";
			
		// 주문 승인
		} else if (url.equals("/order_confirm_action.ad")) {
			System.out.println("[order_confirm_action.ad] 진입");
			
			adminService.orderConfirmAction(req, res);
			
			viewPage = "/manager/order/order_confirm_action.jsp";
			
		// 주문 취소
		} else if (url.equals("/order_cancel_action.ad")) {
			System.out.println("[order_cancel_action.ad] 진입");
			
			adminService.orderCancelAction(req, res);
			
			viewPage = "/manager/order/order_cancel_action.jsp";
			
		// 배송관리 페이지 이동
		} else if (url.equals("/delivery_list.ad")) {
		
			adminService.deliveryList(req, res);
			
			viewPage = "/manager/delivery/delivery_list.jsp";
			
		// 배송 시작
		} else if (url.equals("/delivery_start_action.ad")) {
			
			adminService.deliveryStartAction(req, res);
			
			viewPage = "/manager/delivery/delivery_start_action.jsp";
		
		// 배송 완료
		} else if (url.equals("/delivery_end_action.ad")) {
			
			adminService.deliveryEndAction(req, res);
			
			viewPage = "/manager/delivery/delivery_end_action.jsp";
		
		// 배송 상세조회
		} else if (url.equals("/delivery_detail.ad")) {
			
			
			
			viewPage = "/manager/delivery/delivery_detail.jsp";
			
		// 환불 조회
		} else if (url.equals("/refund_list.ad")) {
			
			adminService.refundList(req, res);
			
			viewPage = "/manager/refund/refund_list.jsp";
			
		// 환불 승인
		} else if (url.equals("/refund_confirm_action.ad")) {
			
			adminService.refundConfirmAction(req, res);
			
			viewPage = "/manager/refund/refund_confirm_action.jsp";
		
		// 환불 거부
		} else if (url.equals("/refund_reject_action.ad")) {
			
			adminService.refundRejectAction(req, res);
			
			viewPage = "/manager/refund/refund_reject_action.jsp";
		
		// 회원 조회
		} else if (url.equals("/customer_list.ad")) {
			
			adminService.customerList(req, res);
			
			viewPage = "/manager/member/customer_list.jsp";
			
		// 회원 탈퇴처리
		} else if (url.equals("/customer_delete_action.ad")) {
			
			adminService.customerDeleteAction(req, res);
			
			viewPage = "/manager/member/customer_delete_action.jsp";
			
		// 게시판 목록 조회
		} else if(url.equals("/board_list.ad")) {
			
			boardService.boardList(req, res);
			
			viewPage = "/manager/board/board_list.jsp";
			
		// 게시판 등록 페이지
		} else if(url.equals("/board_add.ad")) {
			
			viewPage = "/manager/board/board_add.jsp";
			
		// 게시판 등록 처리
		} else if(url.equals("/board_add_action.ad")) {

			boardService.boardAddAction(req, res);
			
			viewPage = "/manager/board/board_add_action.jsp";
			
		// 게시판 상세 페이지
		} else if(url.equals("/board_detail.ad")) {
			
			viewPage = "/manager/board/board_detail.jsp";
			
		// 게시판 수정 페이지
		} else if(url.equals("/board_update.ad")) {
			
			viewPage = "/manager/board/board_update.jsp";
			
		// 게시판 수정 처리
		} else if(url.equals("/board_update_action.ad")) {
			
			boardService.boardUpdateAction(req, res);
			
			viewPage = "/manager/board/board_update_action.jsp";
			
		// 게시판 삭제 처리
		} else if(url.equals("/board_delete_action.ad")) {
			
			viewPage = "/manager/board/board_delete_action.jsp";
			
		// 리뷰 조회
		} else if (url.equals("/review_list.ad")) {
			
			reviewService.reviewList(req, res);
			
			viewPage = "/manager/review/review_list.jsp";
		
		// 리뷰 삭제
		} else if (url.equals("/review_list.ad")) {
			
			reviewService.reviewDelete(req, res);
			
			viewPage = "/manager/review/review_delete_action.jsp";
		
		// 결산 조회
		} else if (url.equals("/sales_list.ad")) {
			
//			adminService.salesLists(req, res);
			
			viewPage = "/manager/sales/sales_list.jsp";
		}
		
		// jsp 페이지 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}