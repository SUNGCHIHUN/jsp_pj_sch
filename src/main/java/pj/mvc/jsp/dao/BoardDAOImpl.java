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

import pj.mvc.jsp.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	// 커넥션 풀
	DataSource dataSource = null;
	
	// DB 사용을 위한 변수
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// 싱글톤
	private static BoardDAO instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {
		try {
			// context.xml에 설정해 둔 데이터베이스 커넥션 가져오기
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_105");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAOImpl();
		}
		return instance;
	}
	
	@Override
	public Map<String, BoardDTO> selectBoardList(String board_category) {
		System.out.println("selectBoardList() - dao");
		
		// 게시판들을 담을 큰 바구니 생성
		Map<String, BoardDTO> blist = new HashMap<>();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM Boards" +
					     " WHERE board_category=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_category);
			
			// DB에 회원정보 결과 반환
			rs = pstmt.executeQuery();
			
			// 조회된 값을 dto에 저장
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getString("board_no"));
				dto.setBoard_category(rs.getString("board_category"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_contents(rs.getString("board_contents"));
				dto.setBoard_file_name(rs.getString("board_file_name"));
				dto.setBoard_regist_day(rs.getDate("board_regist_day"));
				dto.setBoard_hits(rs.getInt("board_hits"));
				dto.setBoard_state(rs.getString("board_state"));

				blist.put(rs.getString("board_no"), dto);
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

		return blist;
	}

	@Override
	public BoardDTO selectBoardDetail(String board_no) {
		System.out.println("selectBoardDetail() - dao");
		
		BoardDTO dto = new BoardDTO();
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "SELECT * FROM Boards" +
					     " WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no);
			
			// DB에 회원정보 결과 반환
			rs = pstmt.executeQuery();
			
			// 조회된 값을 dto에 저장
			if (rs.next()) {
				dto.setBoard_no(rs.getString("board_no"));
				dto.setBoard_category(rs.getString("board_category"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setCustomer_id(rs.getString("customer_id"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_contents(rs.getString("board_contents"));
				dto.setBoard_file_name(rs.getString("board_file_name"));
				dto.setBoard_regist_day(rs.getDate("board_regist_day"));
				dto.setBoard_hits(rs.getInt("board_hits"));
				dto.setBoard_state(rs.getString("board_state"));

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
		System.out.println(dto);
		return dto;
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		System.out.println("insertBoard() - dao");
		
		// 게시글 등록 결과 [ 성공:1 실패:0 ]
		int insertResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "INSERT INTO Boards(board_no, board_category, board_title, customer_id, board_writer, board_contents, board_state)" + 
						 " VALUES(boards_seq.nextval, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_category());
			pstmt.setString(2, dto.getBoard_title());
			pstmt.setString(3, dto.getCustomer_id());
			pstmt.setString(4, dto.getBoard_writer());
			pstmt.setString(5, dto.getBoard_contents());
			pstmt.setString(6, dto.getBoard_state());
	
			// DB에 게시글 등록 및 결과행 개수 반환
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
	public int insertSimpleBoard(String board_category, BoardDTO dto) {
		System.out.println("insertSimpleBoard() - dao");
		return 0;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		System.out.println("updateBoard() - dao");

		// 게시글 수정 결과 [ 성공:1 실패:0 ]
		int updateResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "UPDATE boards SET board_title=?, board_contents=? WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoard_title());
			pstmt.setString(2, dto.getBoard_contents());
			pstmt.setString(3, dto.getBoard_no());
	
			// DB에 게시글 수정 및 결과행 개수 반환
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
	public int deleteBoard(String board_no) {
		System.out.println("deleteBoard() - dao");

		// 게시글 삭제 결과 [ 성공:1 실패:0 ]
		int deleteResult = 0;
		
		try {
			conn = dataSource.getConnection();
			
			String sql = "DELETE FROM boards WHERE board_no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board_no);
	
			// DB에 게시글 삭제 및 결과행 개수 반환
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

}
