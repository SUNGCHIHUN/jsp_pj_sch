package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.ProductDTO;

public interface ProductDAO {
	
	// 상품 조회
	List<ProductDTO> selectProductList(int start, int end);
	
	// 카테고리별 조회
	List<ProductDTO> selectProductListCategory(int start, int end, String strCategory);
	
	// 상품 검색
	List<ProductDTO> searchProduct(int start, int end, String strName);
	
	// 상품 상세 조회
	ProductDTO selectProductDetail(String strNo);
	
	// 상품 등록
	int insertProduct(ProductDTO dto);
	
	// 상품 수정
	int updateProduct(String product_no, ProductDTO dto);
	
	// 상품 삭제
	int deleteProduct(String product_no);
	
	// 상품 총 개수 조회
	int selectProductTotal();
	
}