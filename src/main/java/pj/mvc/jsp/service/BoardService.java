package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardService {
	// 게시판 조회
	void boardList(HttpServletRequest req, HttpServletResponse res);
	
	// 게시판 상세조회
	void boardDetail(HttpServletRequest req, HttpServletResponse res);
	
	// 게시판 등록 처리
	void boardAddAction(HttpServletRequest req, HttpServletResponse res);
	
	// 게시판 수정 처리
	void boardUpdateAction(HttpServletRequest req, HttpServletResponse res);
	
	// 게시판 삭제 처리
	void boardDeleteAction(HttpServletRequest req, HttpServletResponse res);
}