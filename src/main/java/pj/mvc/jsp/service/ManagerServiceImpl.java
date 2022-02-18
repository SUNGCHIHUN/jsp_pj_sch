package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerServiceImpl implements ManagerService {
	
// ----------------------------------------- [ 회원관리 ] ---------------------------------------------------	
	
	@Override // 회원정보 조회
	public void customerListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerListAction() 서비스 실행");
		
	}

	@Override // 회원 삭제
	public void customerDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCustomerAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 재고관리 ] ---------------------------------------------------	
	
	@Override // 재고조회
	public void stockListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectStockListAction() 서비스 실행");

	}
	
	@Override // 재고등록
	public void stockAddAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertStockAction() 서비스 실행");
		
	}

	@Override // 재고수정
	public void stockUpdateAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateStockAction() 서비스 실행");
		
	}

	@Override // 재고삭제
	public void stockDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteStockAction() 서비스 실행");

	}

// ----------------------------------------- [ 주문관리 ] ---------------------------------------------------	
	
	@Override // 주문목록 조회
	public void orderListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderListAction() 서비스 실행");

	}

	@Override // 주문승인
	public void orderConfirmAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmOrderAction() 서비스 실행");

	}

	@Override // 주문취소
	public void orderCancelAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelOrderAction() 서비스 실행");

	}

// ----------------------------------------- [ 배송관리 ] ---------------------------------------------------	
	
	@Override // 배송조회
	public void deliveryListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectDeliveryAction() 서비스 실행");
		
	}

	@Override // 배송 상세조회
	public void deliveryDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateDeliveryStateAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 환불관리 ] ---------------------------------------------------	

	@Override // 환불 조회
	public void refundListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("refundListAction() 서비스 실행");
	}
	
	@Override // 환불승인
	public void refundConfirmAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmRefundAction() 서비스 실행");
		
	}

	@Override // 환불취소
	public void refundCancelAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelRefundAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 공지사항 ] ---------------------------------------------------	
	
	@Override // 공지사항 조회
	public void noticeListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeListAction() 서비스 실행");
		
	}

	@Override // 공지사항 상세조회
	public void noticeDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeDetailAction() 서비스 실행");
		
	}

	@Override // 공지사항 등록
	public void noticeAddAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertNoticeAction() 서비스 실행");
		
	}

	@Override // 공지사항 수정
	public void noticeUpdateAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override // 공지사항 삭제
	public void noticeDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteNoticeAction() 서비스 실행");

	}
	
// ----------------------------------------- [ 문의사항 ] ---------------------------------------------------	
	
	@Override // 문의사항 조회
	public void askListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskListAction() 서비스 실행");
		
	}

	@Override // 문의사항 상세조회
	public void askDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskDetailAction() 서비스 실행");
		
	}

	@Override // 문의사항 답변 등록
	public void replyAddAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertReplyAction() 서비스 실행");
		
	}

	@Override // 문의사항 답변 수정
	public void replyUpdateAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateReplyAction() 서비스 실행");
		
	}

	@Override // 문의사항 답변 삭제
	public void replyDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteReplyAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 결산 ] ---------------------------------------------------	
	
	@Override // 결산
	public void salesListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectSalesAction() 서비스 실행");
		
	}
}