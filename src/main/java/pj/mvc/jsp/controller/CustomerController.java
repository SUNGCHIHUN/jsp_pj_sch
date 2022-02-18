package pj.mvc.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.service.CustomerService;
import pj.mvc.jsp.service.CustomerServiceImpl;

@WebServlet("*.do")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	
    public CustomerController() {
        service = new CustomerServiceImpl();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		shopAction(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		doGet(req, res);
	}
	
	public void shopAction(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");

		// 세션이 null인 경우 초기화
		service.sessionCheck(req, res);
		
		// url 설정
//		String uri = req.getRequestURI();
//		String contextPath = req.getContextPath();
//		String url = uri.substring(contextPath.length());
		String url = req.getServletPath();
		
		String viewPage = "";
		
		// 메인 페이지 이동
		if (url.equals("/main.do")) {
			System.out.println("[/main.do] 진입");
			
			viewPage = "common/main.jsp";
			
		// 로그인 페이지 이동
		} else if (url.equals("/login.do")) {
			System.out.println("[/login.do] 진입");
			
			viewPage = "customer/login/login.jsp";
			
		// 로그인 처리
		} else if(url.equals("/login_action.do")) {
			System.out.println("[/login_action.do] 진입");
			
			service.loginAction(req, res);
			
			viewPage = "customer/login/login_action.jsp";
			
		// 회원가입 페이지 이동
		} else if (url.equals("/register.do")) {
			System.out.println("[/register.do] 진입");
			
			viewPage = "customer/register/register.jsp";
			
		// 아이디 중복 확인
		}  else if (url.equals("/confirm_id_action.do")) {
			System.out.println("[/login.do] 진입");
			
			service.confirmIdAction(req, res);
			
			viewPage = "customer/register/confirm_id_action.jsp";

		// 회원가입 처리
		} else if(url.equals("/register_action.do")) {
			System.out.println("[/register_action.do] 진입");
			
			service.registerAction(req, res);
			
			viewPage = "customer/register/register_action.jsp";

		// 로그아웃 처리
		} else if (url.equals("/logout_action.do")) {
			System.out.println("[/logout_action.do] 진입");
			
			service.logoutAction(req, res);
		
			viewPage = "customer/logout/logout_action.jsp";
			
		// 회원인증 페이지 이동
		} else if (url.equals("/customer_auth.do")) {
			System.out.println("[/customer_auth.do] 진입");
			
			viewPage = "customer/info/customer_auth.jsp";
			
		// 회원인증 처리
		} else if (url.equals("/customer_auth_action.do")) {
			System.out.println("[/customer_auth_action.do] 진입");

			service.customerAuthAction(req, res);
			
			viewPage = "customer/info/customer_auth_action.jsp";
			
		// 회원정보 조회
		} else if (url.equals("/customer_info.do")) {
			System.out.println("[/customer_info.do] 진입");
			
			service.selectCustomerAction(req, res);
			
			viewPage = "customer/info/customer_info.jsp";
			
		// 회원정보 수정 처리
		} else if (url.equals("/update_customer_action.do")) {
			System.out.println("[/update_customer_action.do] 진입");

			service.updateCustomerAction(req, res);
			
			viewPage = "customer/info/update_customer_action.jsp";
			
		// 회원탈퇴 처리
		} else if (url.equals("/delete_customer_action.do")) {
			System.out.println("[/delete_customer_action.do] 진입");

			service.deleteCustomerAction(req, res);
			
			viewPage = "customer/info/delete_customer_action.jsp";
			
		// 상품목록 조회
		} else if (url.equals("/product_list.do")) {
			System.out.println("[/product_list.do] 진입");

			service.selectProductListAction(req, res);
			
			viewPage = "customer/product/product_list.jsp";

		// 상품상세 페이지 조회
		} else if (url.equals("/product_detail.do")) {
			System.out.println("[/product_detail.do] 진입");

			viewPage = "customer/product/product_detail.jsp";

		// 장바구니 담기 처리
		} else if (url.equals("/cart_add_action.do")) {
			System.out.println("[/cart_add_action.do] 진입");

			viewPage = "customer/cart/cart_add_action.jsp";

		// 구매하기 페이지 이동
		} else if (url.equals("/pay.do")) {
			System.out.println("[/pay.do] 진입");

			viewPage = "customer/pay/pay.jsp";

		// 결제하기 처리
		} else if (url.equals("/pay_action.do")) {
			System.out.println("[/pay_action.do] 진입");

			viewPage = "customer/pay/pay_action.jsp";

		// 공지사항 페이지 이동
		} else if (url.equals("/notice_list.do")) {
			System.out.println("[/notice_list.do] 진입");

			viewPage = "customer/notice/notice_list.jsp";
		
		// 문의사항 페이지 이동
		} else if (url.equals("/ask_list.do")) {
			System.out.println("[/ask_list.do] 진입");

			viewPage = "customer/ask/ask_list.jsp";

		// 주문목록 페이지 이동
		} else if (url.equals("/order_list.do")) {
			System.out.println("[/order_list.do] 진입");

			viewPage = "customer/order/order_list.jsp";
		
		// 장바구니 페이지 이동
		} else if (url.equals("/cart_list.do")) {
			System.out.println("[/cart_list.do] 진입");

			viewPage = "customer/cart/cart_list.jsp";

		// 장바구니물품 구매하기 페이지 이동
		}  else if (url.equals("/product_list.do")) {
			System.out.println("[/product_list.do] 진입");

			viewPage = "customer/product/product_list.jsp";

		}
		
		System.out.println("-------------------------------");
		System.out.println("| 현재 sessionId  : " + req.getSession().getAttribute("sessionId") + " |");
		System.out.println("| 현재 authResult : " + req.getSession().getAttribute("authResult") + " |");
		System.out.println("-------------------------------");
		
		// jsp 화면으로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);
	}
}