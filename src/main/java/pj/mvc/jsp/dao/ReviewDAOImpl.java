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

import pj.mvc.jsp.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO {
	// DBCP
	DataSource dataSource;
	
	// DB사용 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 싱글톤
	private static ReviewDAO instance = new ReviewDAOImpl();
	private ReviewDAOImpl() {
		try {
			Context context = new InitialContext();
			this.dataSource = (DataSource)context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	public static ReviewDAO getInstance() {
		if (instance == null) {
			instance = new ReviewDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Map<String, ReviewDTO> selectReview(String strNo) {
		System.out.println("selectReview() - dao");

		// 상품리뷰들을 담을 큰바구니 생성
		Map<String, ReviewDTO> rlist = new HashMap<>();

		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM review WHERE product_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strNo);
			
			rs = pstmt.executeQuery();
			
			// 조회가 안될 때까지 반복
			while (rs.next()) {
				// 조회된 상품정보를 작은 바구니 dto에 담는다.
				ReviewDTO dto = new ReviewDTO();
				dto.setReview_no(rs.getString("review_no"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setReview_writer(rs.getString("review_writer"));
				dto.setReview_contents(rs.getString("review_contents"));
				dto.setReview_regist_day(rs.getDate("review_regist_day"));
				dto.setProduct_no(rs.getString("product_no"));
				dto.setReview_star(rs.getInt("review_star"));
				
				rlist.put(rs.getString("review_no"), dto);
			}
			
			System.out.println(rlist);
			
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
		
		return rlist;
	}

	@Override	// 리뷰 DB에 등록
	public int insertReview(ReviewDTO dto) {
		System.out.println("insertReview - dao");
		
		// 리뷰 등록 결과
		int insertResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql ="INSERT INTO review(review_no, customer_id, review_writer, review_contents, review_regist_day, product_no, review_star)" + 
						" VALUES (review_seq.nextval, ?, ?, ?, sysdate, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getReview_writer());
			pstmt.setString(3, dto.getReview_contents());
			pstmt.setString(4, dto.getProduct_no());
			pstmt.setInt(5, dto.getReview_star());
			
			insertResult = pstmt.executeUpdate();
			System.out.println("insertResult = " + insertResult);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용자원 해제
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return insertResult;
	}
	
	@Override
	public int deleteReview(String review_no) {
		System.out.println("deleteReview() - dao");
		
		// 리뷰 삭제 결과
		int deleteResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql ="DELETE FROM review WHERE review_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review_no);
			
			deleteResult = pstmt.executeUpdate();
			System.out.println("deleteResult = " + deleteResult);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용자원 해제
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return deleteResult;
	}
}