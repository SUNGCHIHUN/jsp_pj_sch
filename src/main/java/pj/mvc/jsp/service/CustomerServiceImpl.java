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

	@Override // 로그인 상태 확인
	public void loginStateAction(HttpServletRequest req, HttpServletResponse res) {
		// 로그인 상태 체크
		int loginResult = 2;
		
		// 로그인 상태를 가지고있는 request객체가 있으면 받아와 설정
		if (req.getParameter("loginResult") != null) {
			loginResult = Integer.parseInt(req.getParameter("loginResult")); 
		}
		
		// 로그인 상태 설정
		req.setAttribute("loginResult", loginResult);
		System.out.println("loginResult : " + loginResult);		
		
	}
	
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
		req.getSession().setAttribute("authResult", 0);
		
		// 로그인 성공 여부 설정
		req.setAttribute("loginResult", loginResult);
	}

	@Override
	public void logoutAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("logoutAction() 서비스 실행");
		// 세션 해제
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

	@Override	// 회원가입 처리
	public void registerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("registerAction() 서비스 실행");
		// 회원가입 성공여부
		int registerResult = 0;
		
		// 회원가입 데이터를 dto에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));

		String tel = req.getParameter("tel1") + "-" + req.getParameter("tel1") + "-" + req.getParameter("tel1");
		dto.setCustomer_tel(tel);
		
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);
		
		// DB에서 회원가입 수행
		registerResult = dao.insertCustomer(dto);
		
		// 회원가입 결과 reuqest 객체에 설정
		req.setAttribute("registerResult", registerResult);
	}

//-------------------------------------- [ 회원정보 ] --------------------------------------------	

	@Override // 회원인증
	public void customerAuthAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("customerAuthAction() 서비스 실행");
		
		// 회원의 인증 상태를 세션에서 받아옴
		int authResult = (Integer)req.getAttribute("authResult");
		
		// 인증이 이미 끝난 상태이면 인증필요없으므로 인증성공값을 넘긴다.
		if (authResult == 1) {
			
		} else {

		// 인증을 한 적이 없으면 회원을 조회하여 인증을 수행한다.
		}
		
		
		// 인증 결과를 session 객체에 설정해준다.
		
	}
	
	@Override // 회원정보 조회
	public void selectCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerAction() 서비스 실행");
		
		int selectCnt = 0; // 회원정보 조회 성공여부[1:성공 0:실패]
		
		// 1. 세션 아이디를 받아온다.
		String sessionId = (String)req.getSession().getAttribute("sessionId");
		
		
		
		
	}

	@Override // 회원정보 수정
	public void updateCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateCustomerAction() 서비스 실행");
		
		// 1. 회원정보 데이터를 받아서 DTO에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));
		String tel = req.getParameter("tel1") + "-" + 
						req.getParameter("tel2") + "-" + 
						req.getParameter("tel3");
		dto.setCustomer_tel(tel);
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);
		
		// 2. DAO를 생성하여 DTO를 가지고 DB update를 수행한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		int updateResult = dao.updateCustomer(dto);
		
		// 3. 수정 결과를 request객체에 담아준다. 
		req.setAttribute("updateCnt", updateResult);

	}

	@Override // 회원정보 삭제
	public void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCustomerAction() 서비스 실행");
		
	}

//-------------------------------------- [ 공지사항 ] --------------------------------------------	

	@Override // 공지사항 조회
	public void selectNoticeListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeListAction() 서비스 실행");

	}

	@Override // 공지사항 상세조회
	public void selectNoticeDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeDetailAction() 서비스 실행");
		
	}
	
//-------------------------------------- [ 상품 ] --------------------------------------------	

	@Override // 상품조회
	public void selectProductListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectProductListAction() 서비스 실행");
		
	}

	@Override // 상품 상세조회
	public void selectProductDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectProductDetailAction() 서비스 실행");
		
	}

	@Override // 상품 구매하기
	public void buyProductAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("buyProductAction() 서비스 실행");
		
	}
	
//-------------------------------------- [ 상품리뷰 ] --------------------------------------------	

	@Override // 상품리뷰 조회
	public void selectProductReviewListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectProductReviewListAction() 서비스 실행");
		
	}

	@Override // 상품리뷰 등록
	public void insertReviewAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertReviewAction() 서비스 실행");
		
	}

	@Override // 상품리뷰 삭제
	public void deleteReviewAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteReviewAction() 서비스 실행");
		
	}
	
//-------------------------------------- [ 장바구니 ] --------------------------------------------	

	@Override // 장바구니 등록
	public void insertCartAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertCartAction() 서비스 실행");
		
	}

	@Override // 장바구니 조회
	public void selectCartListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCartListAction() 서비스 실행");
		
	}

	@Override // 장바구니 개별 삭제
	public void deleteCartAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCartAction() 서비스 실행");
		
	}

	@Override// 장바구니 구매
	public void buyCartProductAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("buyCartProductAction() 서비스 실행");
		
	}
	
//-------------------------------------- [ 문의사항 ] --------------------------------------------	

	@Override // 문의사항 조회
	public void selectAskListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskListAction() 서비스 실행");
		
	}

	@Override // 문의사항 상세조회
	public void selectAskDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskDetailAction() 서비스 실행");
		
	}

	@Override // 문의사항 등록
	public void insertAskAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertAskAction() 서비스 실행");
		
	}

	@Override // 문의사항 수정
	public void updateAskAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateAskAction() 서비스 실행");
		
	}

	@Override // 문의사항 삭제
	public void deleteAskAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteAskAction() 서비스 실행");
		
	}
	
//--------------------------------------- [ 주문 ] ---------------------------------------------

	@Override // 주문목록 조회
	public void selectOrderListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderListAction() 서비스 실행");
		
	}

	@Override // 주문 상세조회
	public void selectOrderDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderDetailAction() 서비스 실행");
		
	}

	@Override // 주문 취소
	public void cancelOrderAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelOrderAction() 서비스 실행");
		
	}

	@Override // 환불
	public void refundAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("refundAction() 서비스 실행");
		
	}
}