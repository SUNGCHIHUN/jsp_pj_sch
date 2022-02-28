package pj.mvc.jsp.dao;

import java.util.List;

import pj.mvc.jsp.dto.BoardDTO;

public interface BoardDAO {

	// 게시판 조회
	List<BoardDTO> selectBoardList(int start, int end, String board_category);
	
	// 게시판 상세조회
	BoardDTO selectBoardDetail(String board_no);

	// 게시글 등록
	int insertBoard(BoardDTO dto);

	// 게시판 수정
	int updateBoard(BoardDTO dto);
	
	// 게시판 삭제
	int deleteBoard(String board_no);
	
	// 게시판 총 개수
	int selectBoardTotal(String board_category);
}