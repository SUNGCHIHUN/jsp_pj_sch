package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.DeliveryDTO;
import pj.mvc.jsp.dto.OrderDTO;

public interface OrderDAO {

	// 주문 목록 조회
	List<OrderDTO> selectOrder(int start, int end, String customer_id);
	
	// 결제 후 주문 등록
	int insertOrder(List<OrderDTO> olist);

	// 배송상태 조회
	List<DeliveryDTO> selectDeliveryDetail(String billing_number);
	
	// 상태 변경
	int updateState(String order_no, String state);

	// 주문 총 개수
	int selectOrderTotal(String customer_id);

}
