package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ManagerService {


//-------------------------- [ 회원관리 ] --------------------------------	

	// 회원 조회
	void selectCustomerListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원 삭제
	void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 재고관리 ] --------------------------------	
	
	// 재고 조회
	void selectStockListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 등록
	void insertStockAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 수정
	void updateStockAction(HttpServletRequest req, HttpServletResponse res);
	
	// 재고 삭제
	void deleteStockAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 주문관리 ] --------------------------------	
	
	// 주문 조회
	void selectOrderListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 주문 승인
	void confirmOrderAction(HttpServletRequest req, HttpServletResponse res);
	
	// 주문 취소
	void cancelOrderAction(HttpServletRequest req, HttpServletResponse res);
	
	// 배송 조회
	void selectDeliveryAction(HttpServletRequest req, HttpServletResponse res);
	
	// 배송 상태 변경
	void updateDeliveryStateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 환불 승인
	void confirmRefundAction(HttpServletRequest req, HttpServletResponse res);
	
	// 환불 취소
	void cancelRefundAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 공지사항 ] --------------------------------	
	
	// 공지사항 조회
	void selectNoticeListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 상세조회
	void selectNoticeDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 등록
	void insertNoticeAction(HttpServletRequest req, HttpServletResponse res);
	
	// 공지사항 수정
	void updateNoticeAction(HttpServletRequest req, HttpServletResponse res);

	// 공지사항 삭제
	void deleteNoticeAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 문의사항 ] --------------------------------	

	// 문의사항 조회
	void selectAskListAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 상세조회
	void selectAskDetailAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 등록
	void insertReplyAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 수정
	void updateReplyAction(HttpServletRequest req, HttpServletResponse res);
	
	// 문의사항 답변 삭제
	void deleteReplyAction(HttpServletRequest req, HttpServletResponse res);
	
//-------------------------- [ 결산 ] --------------------------------	

	// 결산내역 조회
	void selectSalesAction(HttpServletRequest req, HttpServletResponse res);
}