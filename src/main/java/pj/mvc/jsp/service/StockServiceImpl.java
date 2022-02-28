package pj.mvc.jsp.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.ProductDAO;
import pj.mvc.jsp.dao.ProductDAOImpl;
import pj.mvc.jsp.dto.ProductDTO;
import pj.mvc.jsp.util.Paging;

public class StockServiceImpl implements StockService {
	
	// 상품 등록
	@Override
	public void stockAddAction(HttpServletRequest req, HttpServletResponse res) {
		
		// 화면에서 데이터를 받아옵니다.
		ProductDTO dto = new ProductDTO();
		dto.setProduct_name(req.getParameter("p_name"));
		dto.setProduct_category(req.getParameter("p_category"));
		dto.setProduct_price(Integer.parseInt(req.getParameter("p_price")));
		dto.setProduct_amount(Integer.parseInt(req.getParameter("p_amount")));
		dto.setProduct_img_name("/jsp_pj_sch/resources/images/upload/" + (String)req.getAttribute("fileName"));
		
		// DAO를 생성하여 상품을 DB에 저장합니다.
		ProductDAO dao = ProductDAOImpl.getInstance();
		int insertResult = dao.insertProduct(dto);
		
		// request객체에 결과를 저장합니다.
		req.setAttribute("insertResult", insertResult);
		
	}

	// 상품 수정
	@Override
	public void stockUpdateAction(HttpServletRequest req, HttpServletResponse res) {
	}

	// 상품 삭제
	@Override
	public void stockDeleteAction(HttpServletRequest req, HttpServletResponse res) {
	}

	// 상품 조회
	@Override
	public void stockList(HttpServletRequest req, HttpServletResponse res) {
		
		// 화면에서 값을 받아옵니다.
		String pageNum = req.getParameter("pageNum");
		
		// 페이지 처리
		Paging paging = new Paging(pageNum);
		ProductDAO dao = ProductDAOImpl.getInstance();
		int total = dao.selectProductTotal();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		// DB에서 상품 조회
		List<ProductDTO> plist = dao.selectProductList(start, end);
		
		// request 객체에 저장
		req.setAttribute("paging", paging);
		req.setAttribute("plist", plist);
	}

}
