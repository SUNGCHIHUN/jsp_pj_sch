package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.ReviewDTO;

public interface ReviewDAO {
	
	// 특정 상품 리뷰 DB 조회
	List<ReviewDTO> selectReview(int start, int end, String strNo);
	
	// 특정 상품 리뷰 등록
	int insertReview(ReviewDTO dto);
	
	// 특정 상품 리뷰 DB 삭제
	int deleteReview(String review_no);
	
	// 리뷰 총 개수
	int selectReviewTotal();
}
