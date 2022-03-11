package pj.mvc.jsp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.ReviewDAO;
import pj.mvc.jsp.dao.ReviewDAOImpl;
import pj.mvc.jsp.dto.ReviewDTO;
import pj.mvc.jsp.util.Paging;

public class ReviewServiceImpl implements ReviewService {
	
	@Override
	public void reviewList(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("reviewList() - 서비스 실행");
		
		String pageNum = req.getParameter("pageNum");
		
		ReviewDAO dao = ReviewDAOImpl.getInstance();

		Paging paging = new Paging(pageNum);
		paging.setTotalCount(dao.selectReviewTotal());
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<ReviewDTO> rlist = dao.selectAllReview(start, end);
		
		req.setAttribute("rlist", rlist);
	}

	@Override
	public void reviewDelete(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("reviewDelete() - 서비스 실행");
		
		// 1. 리뷰 번호를 받아온다.
		String review_no = req.getParameter("review_no");
		
		// 2. DAO를 생성하고 DB에서 해당 리뷰번호에 대한 삭제를 처리한다.
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		int deleteResult = dao.deleteReview(review_no);
		
		// 3. 리뷰삭제 결과를 request 객체에 저장한다.
		req.setAttribute("deleteResult", deleteResult);
	}

}
