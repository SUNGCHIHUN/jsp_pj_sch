package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ManagerService {


//-------------------------- [ 회원관리 ] --------------------------------	

	// 회원 조회
	void customerListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원 탈퇴처리
	void customerDeleteAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 재고관리 ] --------------------------------	
	
	// 재고 조회
	void stockListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 등록
	void stockAddAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 수정
	void stockUpdateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 삭제
	void stockDeleteAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 주문관리 ] --------------------------------	
	
	// 주문 조회
	void orderListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 주문 승인
	void orderConfirmAction(HttpServletRequest req, HttpServletResponse res);
	
	// 주문 취소
	void orderCancelAction(HttpServletRequest req, HttpServletResponse res);
	
	// 배송 조회
	void deliveryListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 배송 상세조회
	void deliveryDetailAction(HttpServletRequest req, HttpServletResponse res);

	// 환불 조회
	void refundListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 환불 승인
	void refundConfirmAction(HttpServletRequest req, HttpServletResponse res);
	
	// 환불 취소
	void refundCancelAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 공지사항 ] --------------------------------	
	
	// 공지사항 조회
	void noticeListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 상세조회
	void noticeDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 등록
	void noticeAddAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 수정
	void noticeUpdateAction(HttpServletRequest req, HttpServletResponse res);

	// 공지사항 삭제
	void noticeDeleteAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 문의사항 ] --------------------------------	

	// 문의사항 조회
	void askListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 상세조회
	void askDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 등록
	void replyAddAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 수정
	void replyUpdateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 삭제
	void replyDeleteAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 결산 ] --------------------------------	

	// 결산내역 조회
	void salesListAction(HttpServletRequest req, HttpServletResponse res);
}