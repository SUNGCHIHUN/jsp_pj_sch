package pj.mvc.jsp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dao.OrderDAO;
import pj.mvc.jsp.dao.OrderDAOImpl;
import pj.mvc.jsp.dto.CustomerDTO;
import pj.mvc.jsp.dto.OrderDTO;
import pj.mvc.jsp.util.Paging;

public class AdminServiceImpl implements AdminService {
	
// ----------------------------------------- [ 회원관리 ] ---------------------------------------------------	
	
	@Override // 회원정보 조회
	public void customerList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerList() 서비스 실행");
		
		// 화면에서 값을 받는다.
		String pageNum = req.getParameter("pageNum");
		
		// DAO를 생성하여 회원정보를 조회한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		
		Paging paging = new Paging(pageNum);
		int total = dao.selectCustomerTotal();
		paging.setTotalCount(total);

		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<CustomerDTO> clist = dao.selectCustomerList(start, end);
		
		// request에 결과를 저장한다.
		req.setAttribute("paging", paging);
		req.setAttribute("clist", clist);
		
	}

	@Override // 회원 삭제
	public void customerDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("customerDeleteAction() 서비스 실행");
		
		// 화면에서 값을 받는다.
		String pageNum = req.getParameter("pageNum");
		String customer_id = req.getParameter("customer_id");
		
		// DAO를 생성하여 회원 삭제처리한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		int updateResult = dao.deleteCustomer(customer_id);
		
		// request에 결과를 저장한다.
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
	}
	
// ----------------------------------------- [ 재고관리 ] ---------------------------------------------------	
	
	@Override // 재고조회
	public void stockList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectStockList() 서비스 실행");

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
	public void orderList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderListAction() 서비스 실행");
		
		// 화면으로부터 데이터를 입력받는다.
		String pageNum = req.getParameter("pageNum");

		// DAO 생성하여 주문목록 조회
		OrderDAO dao = OrderDAOImpl.getInstance();
		
		int total = dao.selectOrderTotal();
		
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<OrderDTO> olist = dao.selectOrderList(start, end);
		
		// request에 결과 저장
		req.setAttribute("olist", olist);
		req.setAttribute("paging", paging);
		
	}

	@Override // 주문승인
	public void orderConfirmAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmOrderAction() 서비스 실행");
		
		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "결제승인");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
		
	}

	@Override // 주문취소
	public void orderCancelAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelOrderAction() 서비스 실행");

		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "결제취소");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
		
	}

// ----------------------------------------- [ 배송관리 ] ---------------------------------------------------	
	
	@Override // 배송조회
	public void deliveryList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectDelivery() 서비스 실행");
		
		// 화면으로부터 데이터를 입력받는다.
		String pageNum = req.getParameter("pageNum");

		// DAO 생성하여 주문목록 조회
		OrderDAO dao = OrderDAOImpl.getInstance();
		
		int total = dao.selectDeliveryTotal();
		
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<OrderDTO> olist = dao.selectOrderDlist(start, end, "결제승인");
		
		// request에 결과 저장
		req.setAttribute("olist", olist);
		req.setAttribute("paging", paging);
		
		
	}

	@Override // 배송 시작처리
	public void deliveryStartAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deliveryStartAction() 서비스 실행");
		
		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "배송시작");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
		
	}

	@Override // 배송 완료처리
	public void deliveryEndAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deliveryEndAction() 서비스 실행");
		
		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "배송완료");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
		
	}
	
	@Override // 배송 상세조회
	public void deliveryDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateDeliveryStateAction() 서비스 실행");
		
	}
	
// ----------------------------------------- [ 환불관리 ] ---------------------------------------------------	

	@Override // 환불 조회
	public void refundList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("refundList() 서비스 실행");
		
		// 화면으로부터 데이터를 입력받는다.
		String pageNum = req.getParameter("pageNum");

		// DAO 생성하여 주문목록 조회
		OrderDAO dao = OrderDAOImpl.getInstance();
		
		int total = dao.selectRefundTotal();
		
		Paging paging = new Paging(pageNum);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<OrderDTO> olist = dao.selectOrderRlist(start, end, "환불요청");
		
		// request에 결과 저장
		req.setAttribute("olist", olist);
		req.setAttribute("paging", paging);
	}
	
	@Override // 환불승인
	public void refundConfirmAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmRefundAction() 서비스 실행");
		
		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "환불완료");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);
		
	}

	@Override // 환불거부
	public void refundRejectAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelRefundAction() 서비스 실행");
		
		// 화면으로부터 값을 받아온다.
		String pageNum = req.getParameter("pageNum");
		String order_no = req.getParameter("order_no");

		// DAO를 생성하여 주문상태를 변경한다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		int updateResult = dao.updateState(order_no, "환불거부");
		
		// request에 결과를 저장
		req.setAttribute("pageNum", pageNum);
		req.setAttribute("updateResult", updateResult);

	}
	
// ----------------------------------------- [ 공지사항 ] ---------------------------------------------------	
	
	@Override // 공지사항 조회
	public void noticeList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeList() 서비스 실행");
		
	}

	@Override // 공지사항 상세조회
	public void noticeDetail(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectNoticeDetail() 서비스 실행");
		
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
	public void askList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskList() 서비스 실행");
		
	}

	@Override // 문의사항 상세조회
	public void askDetail(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectAskDetail() 서비스 실행");
		
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
	public void salesList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectSales() 서비스 실행");
		
	}

}