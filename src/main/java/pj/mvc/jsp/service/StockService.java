package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface StockService {
	
	// 상품 등록
	void stockAddAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품 수정
	void stockUpdateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품 삭제
	void stockDeleteAction(HttpServletRequest req, HttpServletResponse res);
	
	// 상품 조회
	void stockList(HttpServletRequest req, HttpServletResponse res);
	
}