package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerService {
	
	// 디폴트 세션 생성
	void sessionCheck(HttpServletRequest req, HttpServletResponse res);	
	
//-------------------------- [ 로그인 ] --------------------------------

	// 로그인 상태 조회
	void loginStateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 로그인 처리
	void loginAction(HttpServletRequest req, HttpServletResponse res);
	
	// 로그아웃 처리
	void logoutAction(HttpServletRequest req, HttpServletResponse res);

//-------------------------- [ 회원가입 ] --------------------------------		

	// 아이디 중복 체크
	void confirmIdAction(HttpServletRequest req, HttpServletResponse res);

	// 회원가입 처리
	void registerAction(HttpServletRequest req, HttpServletResponse res);

//-------------------------- [ 회원정보 ] --------------------------------	
	
	// 회원인증
	void customerAuthAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원정보 조회
	void selectCustomerAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원정보 수정
	void updateCustomerAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원 탈퇴
	void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 공지사항 ] --------------------------------	

	// 공지사항 조회
	void selectNoticeListAction(HttpServletRequest req, HttpServletResponse res);

	// 공지사항 상세조회
	void selectNoticeDetailAction(HttpServletRequest req, HttpServletResponse res);

//-------------------------- [ 상품 ] --------------------------------	
	
	// 상품 조회
	void selectProductListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품상세 조회
	void selectProductDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품 구매하기
	void buyProductAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 상품리뷰 ] --------------------------------	
	
	// 상품리뷰 조회
	void selectProductReviewListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품리뷰 등록
	void insertReviewAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품리뷰 삭제
	void deleteReviewAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 장바구니 ] --------------------------------	

	// 장바구니 담기
	void insertCartAction(HttpServletRequest req, HttpServletResponse res);
	
	// 장바구니 조회
	void selectCartListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 장바구니 상품삭제
	void deleteCartAction(HttpServletRequest req, HttpServletResponse res);
	
	// 장바구니 상품구매
	void buyCartProductAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 문의사항 ] --------------------------------	
	
	// 문의사항 조회
	void selectAskListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 상세조회
	void selectAskDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 등록
	void insertAskAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 수정
	void updateAskAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 삭제
	void deleteAskAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 주문 ] --------------------------------	
	
	// 주문목록 조회
	void selectOrderListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 배송 상세조회
	void selectOrderDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 주문 취소
	void cancelOrderAction(HttpServletRequest req, HttpServletResponse res);
	
	// 환불
	void refundAction(HttpServletRequest req, HttpServletResponse res);
	
}