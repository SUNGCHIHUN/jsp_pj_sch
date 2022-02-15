package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CustomerDAOImpl implements CustomerDAO {
	// 커넥션 풀
	DataSource dataSource = null;
	
	// DB 사용을 위한 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤
	private static CustomerDAO instance = new CustomerDAOImpl();
	
	private CustomerDAOImpl() {
		try {
			// context.xml에 설정해 둔 데이터베이스 커넥션 가져오기
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static CustomerDAO getInstance() {
		if (instance == null) {
			instance = new CustomerDAOImpl();
		}
		return instance;
	}
	
	@Override
	public int confirmId(String strId) {
		int dupChk = 0;
		try {

			// DB 커넥션 가져오기
			conn = dataSource.getConnection();
			
			// 해당 아이디 회원 조회 쿼리 및 설정
			String sql = "SELECT * FROM mvc_customer_tbl WHERE id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);
			
			// 쿼리 실행 및 결과 rs에 저장
			rs = pstmt.executeQuery();
			
			// 해당 아이디에 대한 회원정보가 존재하면 1 반환
			if (rs.next()) dupChk = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 사용한 자원 해제
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return dupChk;
	}

}
