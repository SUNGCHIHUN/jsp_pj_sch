package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.ShelfDTO;

public interface ShelfDAO {
	
	
	// 장바구니 리스트 조회
	List<ShelfDTO> selectCartList(String customer_id);
	
	// 장바구니 개별 조회
	ShelfDTO selectCartItem(String customer_id, String product_no);
	
	// 장바구니 상품 수량 변경
	int updateCartItemAmount(String shelf_no, int amount);
	
	// 장바구니 등록 처리
	int insertCartItem(ShelfDTO dto);
	
	// 장바구니 중복 등록 처리
	public int InsertDupCartItem(String shelf_no, int amount);
	
	// 장바구니 개별 삭제
	int deleteCartItem(String[] shelf_no_list);
	
	// 장바구니 비우기
	int deleteCartAll();
	
	// 장바구니 구매
	int buyCartProduct();
}