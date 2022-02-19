package pj.mvc.jsp.dao;

import java.util.Map;

import pj.mvc.jsp.dto.ProductDTO;
import pj.mvc.jsp.dto.ReviewDTO;

public interface ProductDAO {
	
	// 상품 DB 조회
	Map<String, ProductDTO> selectProduct();
	
	// 카테고리별 DB 조회
	Map<String, ProductDTO> selectProductCategory(String strCategory);
	
	// 상품 검색
	Map<String, ProductDTO> searchProduct(String strName);
	
	// 특정 상품 DB 조회
	ProductDTO selectProductDetail(String strNo);	
	
	// 특정 상품 리뷰 DB 조회
	Map<String, ReviewDTO> selectReview(String strNo);
	
	// 특정 상품 리뷰 등록
	int insertReview(ReviewDTO dto);
	
	// 특정 상품 리뷰 DB 삭제
	int deleteReview(String review_no);
	
	// 상품 수량확인
	int productAmountCheck(String strNo);

}