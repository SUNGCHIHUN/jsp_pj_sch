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

import pj.mvc.jsp.dto.ShelfDTO;

public class ShelfDAOImpl implements ShelfDAO {
	// 커넥션 풀
	DataSource dataSource = null;
	
	// DB 사용을 위한 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤
	private static ShelfDAO instance = new ShelfDAOImpl();
	
	private ShelfDAOImpl() {
		try {
			// context.xml에 설정해 둔 데이터베이스 커넥션 가져오기
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static ShelfDAO getInstance() {
		if (instance == null) {
			instance = new ShelfDAOImpl();
		}
		return instance;
	}
	
	
	@Override
	public int insertCartItem(ShelfDTO dto) {
		System.out.println("insertCart() - dao");
		
		// 장바구니 등록 결과 [ 성공:1 실패:0 ]
		int insertResult = 0;
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO shelf(shelf_no, customer_id, product_no, amount)" + 
					     " VALUES(shelf_seq.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getProduct_no());
			pstmt.setInt(3, dto.getAmount());
	
			// DB에 장바구니 등록 및 결과행 개수 반환
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

	@Override
	public Map<String, ShelfDTO> selectCartList(String customer_id) {
		System.out.println("selectCartList() - dao");
		
		// 장바구니 정보를 담을 큰 바구니 생성
		Map<String, ShelfDTO> slist = new HashMap<>();
		
		try {
			conn = dataSource.getConnection();
		
			String sql = "SELECT s.shelf_no, s.customer_id, s.product_no, p.product_img_name, p.product_name, p.product_price, s.amount"
					+ "  FROM shelf s"
					+ "  JOIN products p"
					+ "    ON s.product_no = p.product_no"
					+ " WHERE customer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customer_id);

			// DB에 장바구니 조회결과 반환
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					ShelfDTO dto = new ShelfDTO();
					dto.setShelf_no(rs.getString("shelf_no"));
					dto.setCustomer_id(rs.getString("customer_id"));
					dto.setProduct_no(rs.getString("product_no"));
					dto.setProduct_img_name(rs.getString("product_img_name"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_price(rs.getString("product_price"));
					dto.setAmount(rs.getInt("amount"));

					slist.put(rs.getString("shelf_no"), dto);
					
				} while(rs.next());
			}
			
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("slist : " + slist);
		return slist;
	}

	@Override
	public int updateCartItemAmount(String shelf_no, int amount) {
		System.out.println("updateCartAmount() - dao");
		
		// 장바구니 수정 결과 [ 성공:1 실패:0 ]
		int updateResult = 0;
		try {
			conn = dataSource.getConnection();
			
			String sql = "UPDATE shelf SET amount=? WHERE shelf_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);
			pstmt.setString(2, shelf_no);
			
			updateResult = pstmt.executeUpdate();
			
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
		
		System.out.println("updateResult : " + updateResult);
		return updateResult;
	}

	@Override
	public int deleteCartItem(String[] shelf_no_list) {
		System.out.println("deleteCart() - dao");
		
		// 장바구니 삭제 개수
		int deleteResult = 0;
		try {
			conn = dataSource.getConnection();

			String sql = "DELETE FROM shelf WHERE shelf_no=?";
			pstmt = conn.prepareStatement(sql);
			
			// 체크박스로 선택한 수량만큼 삭제 처리
			int i = 0;
			for (i=0; i<shelf_no_list.length; i++) {
				pstmt.setString(1, shelf_no_list[i]);
				pstmt.executeUpdate();
			}
			
			// 삭제된 개수
			deleteResult = i;
			
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
		
		System.out.println("deleteResult : " + deleteResult);
		return deleteResult;
	}

	@Override
	public int deleteCartAll() {
		System.out.println("deleteCartAll() - dao");
		
		// 장바구니 등록 결과 [ 성공:1 실패:0 ]
		int deleteResult = 0;
		try {
			conn = dataSource.getConnection();
			
			String sql = "DELETE FROM shelf";
			pstmt = conn.prepareStatement(sql);
			
			deleteResult = pstmt.executeUpdate();
			
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
		
		System.out.println("deleteResult : " + deleteResult);
		return deleteResult;
	}

	@Override
	public int buyCartProduct() {
		return 0;
	}

	@Override
	public ShelfDTO selectCartItem(String customer_id, String product_no) {
		System.out.println("selectCrat() - dao");
		
		// 상품 조회 결과 바구니
		ShelfDTO dto = null;
		
		try {
			conn = dataSource.getConnection();
			
			String sql2 = "SELECT * FROM shelf WHERE customer_id=? AND product_no=?";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, customer_id);
			pstmt.setString(2, product_no);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new ShelfDTO();
				dto.setShelf_no(rs.getString("shelf_no"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setAmount(rs.getInt("amount"));
				dto.setProduct_no(rs.getString("product_no"));
				
			}
			
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
		
		return dto;
	}
	
}