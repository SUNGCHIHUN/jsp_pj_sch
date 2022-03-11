package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ReviewService {
	// 상품리뷰 조회
	void reviewList(HttpServletRequest req, HttpServletResponse res);
	
	// 상품리뷰 삭제
	void reviewDelete(HttpServletRequest req, HttpServletResponse res);
}
