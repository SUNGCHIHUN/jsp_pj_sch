package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<ProductDTO> selectProductList(int start, int end) {
		System.out.println("selectProductList() - dao");
		
		// 상품조회 정보들을 담을 큰바구니
		List<ProductDTO> plist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT *"
					+ "  FROM ("
					+ "        SELECT A.*, ROWNUM AS rn"
					+ "          FROM (SELECT *"
					+ "                  FROM products"
					+ "                 ORDER BY product_no DESC"
					+ "                ) A"
					+ "       )"
					+ " WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rs = pstmt.executeQuery();
			
			// 조회되지 않을 때까지 확인
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
				plist.add(dto);
			}
			System.out.println("상품이 " + plist.size() + "건 검색되었습니다.");
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
	public List<ProductDTO> selectProductListCategory(int start, int end, String strCategory) {
		System.out.println("selectProductListCategory() - dao");
		
		// 상품조회 정보들을 담을 큰바구니
		List<ProductDTO> plist = new ArrayList<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT *"
					+ "  FROM ("
					+ "        SELECT A.*, ROWNUM AS rn"
					+ "          FROM (SELECT *"
					+ "                  FROM products"
					+ "                 WHERE product_category=?"
					+ "                 ORDER BY product_no DESC"
					+ "                ) A"
					+ "       )"
					+ " WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strCategory);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rs = pstmt.executeQuery();
			
			// 조회되지 않을 때까지 확인
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
				plist.add(dto);
				
			}
			
			System.out.println("상품이 " + plist.size() + "건 검색되었습니다.");
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
	public List<ProductDTO> searchProduct(int start, int end, String strName) {
		return null;
	}

	@Override
	public ProductDTO selectProductDetail(String strNo) {
		System.out.println("selectProductDetail() - dao");

		// 상품정보를 담을 바구니 생성
		ProductDTO dto = new ProductDTO();

		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM products WHERE product_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strNo);
			
			rs = pstmt.executeQuery();
			
			// 조회된 상품정보를 dto에 담는다.
			if (rs.next()) {
				dto.setProduct_no(rs.getString("product_no"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_price(rs.getInt("product_price"));
				dto.setProduct_amount(rs.getInt("product_amount"));
				dto.setProduct_regist_day(rs.getDate("product_regist_day"));
				dto.setProduct_img_name(rs.getString("product_img_name"));
				dto.setProduct_category(rs.getString("product_category"));
			}
			
			System.out.println(dto);
			
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
		
		return dto;
	}

	// 상품 등록
	@Override
	public int insertProduct(ProductDTO dto) {
		
		// 상품 등록 결과 [ 성공:1 실패:0 ]
		int insertResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO Products(product_no, product_name, product_price, product_amount, product_regist_day, product_img_name, product_category)" + 
						 " VALUES(products_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getProduct_name());
			pstmt.setInt(2, dto.getProduct_price());
			pstmt.setInt(3, dto.getProduct_amount());
			pstmt.setString(4, dto.getProduct_img_name());
			pstmt.setString(5, dto.getProduct_category());

			// DB에 상품 등록 및 결과행 개수 반환
			insertResult = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("insertResult : " + insertResult);
		return insertResult;
	}

	// 상품 수정
	@Override
	public int updateProduct(String product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 상품 삭제
	@Override
	public int deleteProduct(String product_no) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 상품 총 개수
	@Override
	public int selectProductTotal() {
		System.out.println("selectProductTotal() - dao");
			
		int total = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT COUNT(*) total FROM Products";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if (rs.next()) total = rs.getInt("total");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
}