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
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	
    public CustomerServlet() {
        service = new CustomerServiceImpl();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		
		// url 설정
//		String uri = req.getRequestURI();
//		String contextPath = req.getContextPath();
//		String url = uri.substring(contextPath.length());
		String url = req.getServletPath();
		
		String viewPage = "";
		
		if (url.equals("/*.do")) {
			
		// 로그인 페이지 이동
		} else if (url.equals("/login.do")) {
			System.out.println("[/login.do] 진입");
			
			viewPage = "customer/login/login.jsp";
			
		// 로그인하기
		} else if(url.equals("/login_action.do")) {
			System.out.println("[/login_action.do] 진입");
			
			viewPage = "customer/login/login_action.jsp";
			
		// 회원가입 페이지 이동
		} else if (url.equals("/register.do")) {
			System.out.println("[/register.do] 진입");
			
			viewPage = "customer/register/register.jsp";
			
		// 아이디 중복 확인
		}  else if (url.equals("/confirm_id_action.do")) {
			System.out.println("[/login.do] 진입");
			
			// 입력받은 아이디 받아오기
			String strId = req.getParameter("id");
			
			// 아이디 중복 체크 서비스 수행 및 결과 저장
			int dupChk = service.confirmIdAction(req, res);
			
			// 결과를 request 객체에 저장
			req.setAttribute("strId", strId);
			req.setAttribute("dupChk", dupChk);
			
			viewPage = "customer/register/confirm_id_action.jsp";

		// 회원가입
		} else if(url.equals("/register_action.do")) {
			System.out.println("[/register_action.do] 진입");
			
			service.registerAction(req, res);
			
			viewPage = "customer/register/register_action.jsp";

		}

		// jsp 화면으로 이동
		RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
		dispatcher.forward(req, res);	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}