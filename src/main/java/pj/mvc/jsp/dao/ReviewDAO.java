package pj.mvc.jsp.dao;

import java.util.Map;

import pj.mvc.jsp.dto.ReviewDTO;

public interface ReviewDAO {
	
	// 특정 상품 리뷰 DB 조회
	Map<String, ReviewDTO> selectReview(String strNo);
	
	// 특정 상품 리뷰 등록
	int insertReview(ReviewDTO dto);
	
	// 특정 상품 리뷰 DB 삭제
	int deleteReview(String review_no);
}
