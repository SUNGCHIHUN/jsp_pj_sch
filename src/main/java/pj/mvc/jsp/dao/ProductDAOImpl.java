package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pj.mvc.jsp.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {
	
	// DBCP
	DataSource dataSource;
	
	// DB사용 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 싱글톤
	private static ProductDAO instance = new ProductDAOImpl();
	private ProductDAOImpl() {
		try {
			Context context = new InitialContext();
			this.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAOImpl();
		}
		return instance;
	}
	
	@Override // 상품목록 조회
	public Map<String, ProductDTO> selectProduct() {
		System.out.println("selectProduct() - dao");
		
		// 상품조회 정보들을 담을 큰바구니
		Map<String, ProductDTO> plist = new HashMap<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM products";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			// 조회되지 않을 때까지 확인
			int i = 0;
			while(rs.next()) {
				// 한 줄을 읽어서 dto에 담는다.
				ProductDTO dto = new ProductDTO();
				dto.setProduct_no(rs.getString("product_no"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setProduct_amount(rs.getInt("product_amount"));
				dto.setProduct_regist_day(rs.getDate("product_regist_day"));
				dto.setProduct_img_name(rs.getString("product_img_name"));
				dto.setProduct_category(rs.getString("product_category"));
				
				// dto를 큰 바구니에 담는다.
				plist.put(rs.getString("product_no"), dto);
				i++;
			}
			System.out.println("상품이 " + i + "건 검색되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용자원 해제
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return plist;
	}

	@Override
	public Map<String, ProductDTO> selectProductCategory(String strCategory) {
		return null;
	}

	@Override
	public Map<String, ProductDTO> searchProduct(String strName) {
		return null;
	}

	@Override
	public ProductDTO selectProductDetail(String strNo) {
		return null;
	}

	@Override
	public Map<String, ProductDTO> selectReview(String strNo) {
		return null;
	}

	@Override
	public int productAmountCheck(String strNo) {
		return 0;
	}
	
}
