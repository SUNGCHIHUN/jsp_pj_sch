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
		System.out.println("stockAddAction() 서비스 실행");
		
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

	// 상품 상세
	@Override
	public void stockDetail(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("stockDetail() 서비스");
		
		// 화면에서 값을 받아옵니다.
		String product_no = req.getParameter("product_no");
		String pageNum = req.getParameter("pageNum");
		
		// DAO를 생성 
		ProductDAO dao = ProductDAOImpl.getInstance();

		// 페이징 처리
		Paging paging = new Paging(pageNum);
		int total = dao.selectProductTotal();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();

		// 조회 결과 저장
		ProductDTO dto = dao.selectProductDetail(product_no);
		
		// request 객체에 저장
		req.setAttribute("p_dto", dto);
		req.setAttribute("pageNum", pageNum);
	}
	
	// 상품 수정
	@Override
	public void stockUpdateAction(HttpServletRequest req, HttpServletResponse res) {
	System.out.println("stockUpdateAction() 서비스 실행");
	
		// 화면으로부터 값을 입력받는다.
		String product_no = req.getParameter("product_no");
		String pageNum = req.getParameter("pageNum");		
		String upload_img_name = (String)req.getAttribute("fileName"); // 수정된 파일명
		String hidden_img_name = req.getParameter("hidden_img_name"); // 기존 파일명

		String img_name = ""; // dto에 넣어줄 파일명 결과
		
		// 파일을 수정하지 않은 경우
		if (upload_img_name == null) {
			System.out.println("이미지를 수정하지 않았습니다. ==> " + hidden_img_name);
			img_name = hidden_img_name;
		// 수정한 경우
		} else {
			System.out.println("이미지를 수정하였습니다. ==> " + hidden_img_name + " -> " + upload_img_name);
			img_name = "/jsp_pj_sch/resources/images/upload/" + upload_img_name;
		}
		
		System.out.println("img_name : " + img_name);
		
		ProductDTO dto = new ProductDTO();
		dto.setProduct_name(req.getParameter("product_name"));
		dto.setProduct_category(req.getParameter("product_category"));
		dto.setProduct_state(req.getParameter("product_state"));
		dto.setProduct_price(Integer.parseInt(req.getParameter("product_price")));
		dto.setProduct_amount(Integer.parseInt(req.getParameter("product_amount")));
		dto.setProduct_img_name(img_name);
		
		System.out.println(dto);
		
		// DAO 생성
		ProductDAO dao = ProductDAOImpl.getInstance();
		int updateResult = dao.updateProduct(product_no, dto);
		
		// request 객체에 저장
		req.setAttribute("updateResult", updateResult);
		
	}

	// 상품 삭제
	@Override
	public void stockDeleteAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("stockDeleteAction() 서비스 실행");
		
		// 화면으로부터 값을 입력받는다.
		String product_no = req.getParameter("product_no");
		String pageNum = req.getParameter("pageNum");
		
		// DAO 생성
		ProductDAO dao = ProductDAOImpl.getInstance();
		int deleteResult = dao.deleteProduct(product_no);
		
		// request 객체에 저장
		req.setAttribute("deleteResult", deleteResult);
		
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
