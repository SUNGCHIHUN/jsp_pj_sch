package pj.mvc.jsp.dao;

import java.util.Map;

import pj.mvc.jsp.dto.ProductDTO;

public interface ProductDAO {
	
	// 상품 DB 조회
	Map<String, ProductDTO> selectProduct();
	
	// 카테고리별 DB 조회
	Map<String, ProductDTO> selectProductCategory(String strCategory);
	
	// 상품 검색
	Map<String, ProductDTO> searchProduct(String strName);
	
	// 특정 상품 DB 조회
	ProductDTO selectProductDetail(String strNo);
}