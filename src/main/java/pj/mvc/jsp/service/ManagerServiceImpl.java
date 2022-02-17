package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerServiceImpl implements ManagerService {
	
// ----------------------------------------- [ 회원관리 ] ---------------------------------------------------	
	
	@Override // 회원정보 조회
	public void selectCustomerListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerListAction() 서비스 실행");
		
	}

	@Override // 회원 삭제
	public void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCustomerAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 재고관리 ] ---------------------------------------------------	
	
	@Override // 재고조회
	public void selectStockListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectStockListAction() 서비스 실행");

	}
	
	@Override // 재고등록
	public void insertStockAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertStockAction() 서비스 실행");
		
	}

	@Override // 재고수정
	public void updateStockAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateStockAction() 서비스 실행");
		
	}

	@Override // 재고삭제
	public void deleteStockAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteStockAction() 서비스 실행");

	}

// ----------------------------------------- [ 주문관리 ] ---------------------------------------------------	
	
	@Override // 주문목록 조회
	public void selectOrderListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderListAction() 서비스 실행");

	}

	@Override // 주문승인
	public void confirmOrderAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmOrderAction() 서비스 실행");

	}

	@Override // 주문취소
	public void cancelOrderAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelOrderAction() 서비스 실행");

	}

// ----------------------------------------- [ 배송관리 ] ---------------------------------------------------	
	
	@Override // 배송조회
	public void selectDeliveryAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectDeliveryAction() 서비스 실행");
		
	}

	@Override // 배송상태 변경
	public void updateDeliveryStateAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateDeliveryStateAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 환불관리 ] ---------------------------------------------------	
	
	@Override // 환불승인
	public void confirmRefundAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmRefundAction() 서비스 실행");
		
	}

	@Override // 환불취소
	public void cancelRefundAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelRefundAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 공지사항 ] ---------------------------------------------------	
	
	@Override // 공지사항 조회
	public void selectNoticeListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeListAction() 서비스 실행");
		
	}

	@Override // 공지사항 상세조회
	public void selectNoticeDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeDetailAction() 서비스 실행");
		
	}

	@Override // 공지사항 등록
	public void insertNoticeAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertNoticeAction() 서비스 실행");
		
	}

	@Override // 공지사항 수정
	public void updateNoticeAction(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	@Override // 공지사항 삭제
	public void deleteNoticeAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteNoticeAction() 서비스 실행");

	}
	
// ----------------------------------------- [ 문의사항 ] ---------------------------------------------------	
	
	@Override // 문의사항 조회
	public void selectAskListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskListAction() 서비스 실행");
		
	}

	@Override // 문의사항 상세조회
	public void selectAskDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskDetailAction() 서비스 실행");
		
	}

	@Override // 문의사항 등록
	public void insertReplyAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertReplyAction() 서비스 실행");
		
	}

	@Override // 문의사항 수정
	public void updateReplyAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateReplyAction() 서비스 실행");
		
	}

	@Override // 문의사항 삭제
	public void deleteReplyAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteReplyAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 결산 ] ---------------------------------------------------	
	
	@Override // 결산
	public void selectSalesAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectSalesAction() 서비스 실행");
		
	}
}