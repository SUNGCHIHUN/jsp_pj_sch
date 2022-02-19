package pj.mvc.jsp.dao;

import java.util.Map;

import pj.mvc.jsp.dto.BoardDTO;

public interface BoardDAO {

	// 게시판 조회
	Map<String, BoardDTO> selectBoardList(String board_category);
	
	// 게시판 상세조회
	BoardDTO selectBoardDetail(String board_no);

	// 게시글 등록
	int insertBoard(BoardDTO dto);
	
	// 게시판 간편등록
	int insertSimpleBoard(String board_category, BoardDTO dto);

	// 게시판 수정
	int updateBoard(BoardDTO dto);
	
	// 게시판 삭제
	int deleteBoard(String board_no);
}