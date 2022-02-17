package pj.mvc.jsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import pj.mvc.jsp.dto.CustomerDTO;

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
			String sql = "SELECT * FROM Customers WHERE customer_id=?";
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

		System.out.println("dupChk : " + dupChk);
		return dupChk;
	}

	@Override
	public int insertCustomer(CustomerDTO dto) {
		// 회원가입 결과 [ 성공:1 실패:0 ]
		int registerResult = 0;
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO Customers(customer_no, customer_id, customer_password, customer_name, zipcode, customer_address, customer_tel, customer_email, customer_regist_day)" + 
						 " VALUES(customers_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCustomer_id());
			pstmt.setString(2, dto.getCustomer_password());
			pstmt.setString(3, dto.getCustomer_name());
			pstmt.setString(4, dto.getZipcode());
			pstmt.setString(5, dto.getCustomer_address());
			pstmt.setString(6, dto.getCustomer_tel());
			pstmt.setString(7, dto.getCustomer_email());

			// DB에 회원정보 등록 및 결과행 개수 반환
			registerResult = pstmt.executeUpdate();
			
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
		
		System.out.println("registerResult : " + registerResult);
		return registerResult;
	}

	@Override
	public int loginCheck(String strId, String strPassword) {
		System.out.println("loginCheck() dao 실행");
		System.out.println("strId : " + strId);
		System.out.println("strPassword : " + strPassword);
		// 로그인 확인 결과 [ 성공:1 실패:0 ]
		int loginResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM Customers WHERE customer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, strId);

			// DB에 회원정보 등록 및 결과 반환
			rs = pstmt.executeQuery();
			
			// 결과가 있으면
			if (rs.next()) {
				// 비밀번호 비교
				if (strPassword.equals(rs.getString("customer_password"))) {
					loginResult = 1;
				} else {
					loginResult = -1;
				}
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원해제
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("loginResult : " + loginResult);
		return loginResult;
	}

	@Override
	public int updateCustomer(CustomerDTO dto) {
		// 회원정보 수정 결과 [ 성공:1 실패:0 ]
				int updateResult = 0;
				try {
					conn = dataSource.getConnection();
					
					String sql = "UPDATE Customers" +
									 " SET password=?, name=?, zipcode=?, address=?, tel=?, email=?" +
									 " WHERE customer_id=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getCustomer_password());
					pstmt.setString(2, dto.getCustomer_name());
					pstmt.setString(3, dto.getZipcode());
					pstmt.setString(4, dto.getCustomer_address());
					pstmt.setString(5, dto.getCustomer_tel());
					pstmt.setString(6, dto.getCustomer_email());
					pstmt.setString(7, dto.getCustomer_id());
					
					// DB에 회원정보 등록 및 결과행 개수 반환
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
		return updateResult;
	}
}