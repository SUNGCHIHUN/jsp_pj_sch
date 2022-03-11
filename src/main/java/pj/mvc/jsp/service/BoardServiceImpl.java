package pj.mvc.jsp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.BoardDAO;
import pj.mvc.jsp.dao.BoardDAOImpl;
import pj.mvc.jsp.dto.BoardDTO;
import pj.mvc.jsp.util.Paging;

public class BoardServiceImpl implements BoardService {

	@Override
	public void boardList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("boardList() 서비스 실행");

		// 1. 게시판의 카테고리와 페이지번호를 받아온다.
		String category = req.getParameter("board_category");
		String pageNum = req.getParameter("pageNum");
		
		// 2. DAO를 생성하여 DB에서 카테고리와 일치하는 게시판을 조회한다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		
		// 페이징 처리
		Paging paging = new Paging(pageNum);
		int total = dao.selectBoardTotal(category);
		System.out.println("total : " + total);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<BoardDTO> blist = dao.selectBoardList(start, end, category);

		// 3. 조회 결과 게시판 목록들을 request객체에 저장한다.
		req.setAttribute("paging", paging);
		req.setAttribute("blist", blist);
		
		// 카테고리
		req.setAttribute("board_category", category);
		
		// 카테고리 한글로 변환
		String ko_category = "";
		if (category.equals("notice")) ko_category="공지사항";
		else if(category.equals("ask")) ko_category = "문의사항";
		req.setAttribute("ko_category", ko_category);
	}

	@Override
	public void boardDetail(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("boardDetail() 서비스 실행");		
		
		// 1. 게시글 번호를 받아온다.
		String board_no = req.getParameter("board_no");
		
		// 2. DAO 생성하여 DB에서 게시글을 조회하고, 결과를 받아온다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		BoardDTO dto = dao.selectBoardDetail(board_no);
		
		// 3. 결과를 request 객체에 저장하여 돌려준다.
		req.setAttribute("board", dto);
		
	}

	@Override
	public void boardAddAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("boardAddAction() 서비스 실행");	
		
		// 1. 카테고리와 게시글 내용들을 받아와 dto에 저장합니다.
		String category = req.getParameter("board_category");

		BoardDTO dto = new BoardDTO();
		dto.setBoard_category(category);
		dto.setBoard_title(req.getParameter("title"));
		dto.setCustomer_id((String)req.getSession().getAttribute("sessionId"));
		dto.setBoard_writer((String)req.getSession().getAttribute("sessionName"));
		dto.setBoard_contents(req.getParameter("contents"));
		
		if (category.equals("ask")) {
			dto.setBoard_state("답변대기");
		}
		
		// 2. DAO를 생성하여 받아온 내용을 DB에 등록합니다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		int insertResult = dao.insertBoard(dto);
		
		// 3. 결과를 받아 request 객체에 저장합니다.
		req.setAttribute("insertResult", insertResult);
	}

	@Override
	public void boardUpdateAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("boardUpdateAction() 서비스 실행");
		
		// 1. 게시글 번호와 수정 내용을 받아옵니다.
		String board_no = req.getParameter("board_no");
		BoardDTO dto = new BoardDTO();
		dto.setBoard_no(board_no);
		dto.setBoard_title(req.getParameter("title"));
		dto.setBoard_contents(req.getParameter("contents"));
		
		// 2. DAO를 생성하고, 받아온 내용을 DB에서 수정합니다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		int updateResult = dao.updateBoard(dto);
		
		// 3. 결과를 request 객체에 저장
		req.setAttribute("updateResult", updateResult);
	}

	@Override
	public void boardDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("boardDeleteAction() 서비스 실행");		
		
		// 1. 게시글 번호를 받아옵니다.
		String board_no = req.getParameter("board_no");
		
		// 2. DAO를 생성하고, 해당 번호의 게시글을 DB에서 삭제합니다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		int deleteResult = dao.deleteBoard(board_no);
		
		// 3. 결과를 request 객체에 저장합니다.
		req.setAttribute("deleteResult", deleteResult);
				
	}

}