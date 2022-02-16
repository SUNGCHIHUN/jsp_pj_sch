package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO dao;
	public CustomerServiceImpl() {
		this.dao = CustomerDAOImpl.getInstance();
	}

//-------------------------- [ 로그인 ] --------------------------------

	@Override
	public void loginAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("loginAction() 서비스 실행");
		// 로그인 성공 여부
		int loginResult = 0;
		
		// 받아온 회원 아이디, 비밀번호
		String strId = req.getParameter("id");
		String strPassword = req.getParameter("password");
		
		// DB에서 로그인 정보 확인
		loginResult = dao.loginCheck(strId, strPassword);
		
		// 로그인 여부에 따라 세션 아이디 설정
		if (loginResult == 1) req.getSession().setAttribute("id", strId);
		else req.getSession().setAttribute("id", "");
		
		// 회원수정을 위한 인증여부 세션 설정
		req.getSession().setAttribute("authOk", 0);
		
		// 로그인 성공 여부 설정
		req.setAttribute("loginResult", loginResult);
	}

	@Override
	public void logoutAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("logoutAction() 서비스 실행");
		req.getSession().invalidate();
	}
	
	@Override
	public void confirmIdAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmIdAction() 서비스 실행");
		// 아이디 중복 여부
		int dupChk = 0;
		
		// 입력받은 아이디값
		String strId = req.getParameter("id");
		
		// DB에서 아이디 중복 조회 및 결과 저장
		dupChk = dao.confirmId(strId);
		
		// 결과 반환 (중복 = 1, 신규 = 0)
		req.setAttribute("dupChk", dupChk);
		
		// 입력받은 아이디 request 객체에 설정
		req.setAttribute("strId", strId);
	}

//-------------------------- [ 회원가입 ] --------------------------------		

	@Override
	public void registerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("registerAction() 서비스 실행");
		// 회원가입 성공여부
		int registerResult = 0;
		
		// 회원가입 데이터를 dto에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);

		String tel = req.getParameter("tel1") + "-" + req.getParameter("tel1") + "-" + req.getParameter("tel1");
		dto.setCustomer_tel(tel);
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));
		
		// DB에서 회원가입 수행
		registerResult = dao.insertCustomer(dto);
		
		// 회원가입 결과 reuqest 객체에 설정
		req.setAttribute("registerResult", registerResult);
	}

//-------------------------------------- [ 회원정보 ] --------------------------------------------	

	@Override
	public void selectCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

//-------------------------------------- [ 공지사항 ] --------------------------------------------	

	@Override
	public void selectNoticeListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectNoticeDetailAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
	
//-------------------------------------- [ 상품 ] --------------------------------------------	

	@Override
	public void selectProductListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectProductDetailAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyProductAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
	
//-------------------------------------- [ 상품리뷰 ] --------------------------------------------	

	@Override
	public void selectProductReviewListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertReviewAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteReviewAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
	
//-------------------------------------- [ 장바구니 ] --------------------------------------------	

	@Override
	public void insertCartAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectCartListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCartAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void buyCartProductAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
	
//-------------------------------------- [ 문의사항 ] --------------------------------------------	

	@Override
	public void selectAskListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectAskDetailAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAskAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAskAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAskAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
	
//--------------------------------------- [ 주문 ] ---------------------------------------------

	@Override
	public void selectOrderListAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectOrderDetailAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrderAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refundAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}
}