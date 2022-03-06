package pj.mvc.jsp.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.BoardDAO;
import pj.mvc.jsp.dao.BoardDAOImpl;
import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dao.OrderDAO;
import pj.mvc.jsp.dao.OrderDAOImpl;
import pj.mvc.jsp.dao.ProductDAO;
import pj.mvc.jsp.dao.ProductDAOImpl;
import pj.mvc.jsp.dao.ReviewDAO;
import pj.mvc.jsp.dao.ReviewDAOImpl;
import pj.mvc.jsp.dao.ShelfDAO;
import pj.mvc.jsp.dao.ShelfDAOImpl;
import pj.mvc.jsp.dto.BoardDTO;
import pj.mvc.jsp.dto.CustomerDTO;
import pj.mvc.jsp.dto.DeliveryDTO;
import pj.mvc.jsp.dto.OrderDTO;
import pj.mvc.jsp.dto.ProductDTO;
import pj.mvc.jsp.dto.ReviewDTO;
import pj.mvc.jsp.dto.ShelfDTO;
import pj.mvc.jsp.dto.ZipcodeDTO;
import pj.mvc.jsp.util.Paging;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO dao;
	public CustomerServiceImpl() {
		this.dao = CustomerDAOImpl.getInstance();
	}

//-------------------------- [ 세션 ] --------------------------------
	
	@Override // 세션 초기화
	public void sessionCheck(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("sessionCheck() 서비스 실행");
		
		// 로그인 상태 세션
		if (req.getSession().getAttribute("loginResult") == null) {
			req.getSession().setAttribute("loginResult", 2);
		}
		
		// 로그인 고객 아이디 세션
		if (req.getSession().getAttribute("sessionId") == null)
			req.getSession().setAttribute("sessionId", "");

		// 로그인 고객 이름 세션
		if (req.getSession().getAttribute("sessionName") == null)
			req.getSession().setAttribute("sessionName", "");

		// 회원정보 조회 인증여부 세션
		if (req.getSession().getAttribute("authResult") == null)
			req.getSession().setAttribute("authResult", 0);
		
	}

//-------------------------- [ 로그인 ] --------------------------------
	
	@Override // 로그인 처리
	public void loginAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("loginAction() 서비스 실행");
		// 로그인 성공 여부
		int loginResult = 0;
		
		// 받아온 회원 아이디, 비밀번호
		String strId = req.getParameter("id");
		String strPassword = req.getParameter("password");
		
		// DB에서 로그인 정보 확인
		loginResult = dao.idPasswordCheck(strId, strPassword);
		
		String strName = (dao.selectCustomer(strId)).getCustomer_name();
		
		// 로그인 여부에 따라 세션 아이디 설정
		if (loginResult == 1) {
			req.getSession().setAttribute("sessionId", strId);
			req.getSession().setAttribute("sessionName", strName);
		}
		
		// 회원수정을 위한 인증여부 세션 설정
		req.getSession().setAttribute("authResult", 0);
		
		// 로그인 성공 여부 설정
		req.getSession().setAttribute("loginResult", loginResult);
	}
	
	@Override
	public void logoutAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("logoutAction() 서비스 실행");
		
		// 세션 해제
		req.getSession().invalidate();
		
	}
	
	@Override // 아이디 중복 체크
	public void confirmIdAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("confirmIdAction() 서비스 실행");
		// 아이디 중복 여부
		int dupChk = 0;
		
		// 입력받은 아이디값
		String strId = req.getParameter("id");
		
		// DB에서 아이디 중복 조회 및 결과 저장
		dupChk = dao.confirmId(strId);
		
		// 결과 반환 (중복 = 1, 신규 = 0)
		req.setAttribute("dupChk", dupChk);
		
		// 입력받은 아이디 request 객체에 설정
		req.setAttribute("strId", strId);
	}
	
//-------------------------- [ 회원가입 ] --------------------------------		

	@Override	// 회원가입 처리
	public void registerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("registerAction() 서비스 실행");
		// 회원가입 성공여부
		int registerResult = 0;
		
		// 회원가입 데이터를 dto에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));

		String tel = req.getParameter("tel1") + "-" + req.getParameter("tel2") + "-" + req.getParameter("tel3");
		dto.setCustomer_tel(tel);
		
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);
		
		// DB에서 회원가입 수행
		registerResult = dao.insertCustomer(dto);
		
		// 회원가입 결과 reuqest 객체에 설정
		req.setAttribute("registerResult", registerResult);
	}

//-------------------------------------- [ 회원정보 ] --------------------------------------------	

	@Override // 회원인증
	public void customerAuthAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("customerAuthAction() 서비스 실행");
		
		// 로그인 성공 여부
		int loginResult = 0;
		
		// 회원의 인증 상태를 세션에서 받아옴
		int authResult = 0;
		
		// 세션이 없으면
		if (req.getSession().getAttribute("authResult") == null) {
			// 세션 생성
			req.getSession().setAttribute("authResult", authResult);
		} 
		
		// 인증이 안되있으면
		if (authResult == 0) {

			// 인증을 한 적이 없으면 회원을 조회하여 인증을 수행한다.
			String strId = (String)req.getSession().getAttribute("sessionId");
			String strPassword = req.getParameter("password");
			CustomerDAO dao = CustomerDAOImpl.getInstance();
			loginResult = dao.idPasswordCheck(strId, strPassword);
			
		}

		// 인증 결과를 request, session 객체에 설정해준다.
		req.setAttribute("loginResult", loginResult);
		req.getSession().setAttribute("authResult", authResult);
		
	}
	
	@Override // 회원정보 조회
	public void selectCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerAction() 서비스 실행");

		// 1. 세션 아이디를 받아온다.
		String strId = (String)req.getSession().getAttribute("sessionId");
		System.out.println("sessionId : " + strId);
		
		// 2. 해당 회원의 정보를 조회한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		CustomerDTO dto = dao.selectCustomer(strId);

		// 3. request 객체에 저장
		req.setAttribute("dto", dto);
		
	}

	@Override // 회원정보 수정
	public void updateCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateCustomerAction() 서비스 실행");
		
		// 1. 회원정보 데이터를 받아서 DTO에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));
		
		String tel = req.getParameter("tel1") + "-" + 
						req.getParameter("tel2") + "-" + 
						req.getParameter("tel3");
		dto.setCustomer_tel(tel);
		
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);
		
		// 2. DAO를 생성하여 DTO를 가지고 DB update를 수행한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		int updateResult = dao.updateCustomer(dto);
		
		// 3. 수정 결과를 request객체에 담아준다. 
		req.setAttribute("updateResult", updateResult);
		System.out.println("updateResult : " + updateResult);
	}

	@Override // 회원정보 삭제
	public void deleteCustomerAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCustomerAction() 서비스 실행");
		
		// 1. 회원 세션 아이디를 받아온다.
		String strId = (String)req.getSession().getAttribute("sessionId");
		
		// 2. DAO를 생성하여 로그인한 고객 아이디로 DB delete를 수행한다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		int deleteResult = dao.deleteCustomer(strId);
		
		// 3. 삭제 결과를 request객체에 담아준다.
		req.setAttribute("deleteResult", deleteResult);
		
	}

//-------------------------------------- [ 상품 ] --------------------------------------------	

	@Override // 상품조회
	public void selectProductListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectProductListAction() 서비스 실행");
		
		// 1. 카테고리를 받아온다.
		String pageNum = req.getParameter("pageNum");
		String category = req.getParameter("product_category");
		
		// 2. DAO와 결과를 담을 바구니 생성
		ProductDAO dao = ProductDAOImpl.getInstance();
		List<ProductDTO> plist;
		
		// 페이징 처리
		Paging paging = new Paging(pageNum);
		int total = dao.selectProductTotal();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		// 카테고리가 없으면
		if (category == null) {
			// DB에서 전체 조회
			plist = dao.selectProductList(start, end);
			category = "all";
		// 카테고리가 있으면
		} else {
			// 해당 카테고리로 DB에서 조회
			plist = dao.selectProductListCategory(start, end, category);
		}
		
		// 3. 조회된 상품정보를 request객체에 저장
		req.setAttribute("plist", plist);
		
		// 카테고리 한글로 변환
		String ko_category = "";
		if (category.equals("all")) ko_category="전체";
		else if(category.equals("energy")) ko_category = "드링크";
		else if(category.equals("carbon")) ko_category = "탄산음료";
		else if(category.equals("water")) ko_category = "생수";
		else if(category.equals("coffee")) ko_category = "커피";
		
		req.setAttribute("paging", paging);
		req.setAttribute("ko_category", ko_category);
		
	}

	@Override // 상품 상세조회
	public void selectProductDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectProductDetailAction() 서비스 실행");
		
		// 1. 선택한 상품번호와 리뷰 페이지번호를 받아온다.
		String product_no = req.getParameter("product_no");
		String pageNum = req.getParameter("pageNum");
		
		// 2. 해당 상품의 상세 내역을 받아온다.
		ProductDAO pdao = ProductDAOImpl.getInstance();
		ProductDTO dto = pdao.selectProductDetail(product_no);
		
		// 3. 해당 상품의 리뷰를 받아온다.
		ReviewDAO rdao = ReviewDAOImpl.getInstance();
		
		// 페이징 처리
		Paging paging = new Paging(pageNum);
		int total = rdao.selectReviewTotal();
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<ReviewDTO> rlist = rdao.selectReview(start, end, product_no);
		
		// 3. 조회된 상품 상세정보, 리뷰를 request에 저장
		req.setAttribute("paging", paging);
		req.setAttribute("p_dto", dto);
		req.setAttribute("rlist", rlist);
		
	}
	
	@Override // 상품 구매하기 처리
	public void buyProductAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("buyProductAction() 서비스 실행");
		
		// 1-1. 화면에서 데이터를 받아온다.
		int buy_state = Integer.parseInt(req.getParameter("buy_state"));
		System.out.println("buyState : " + buy_state);
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		String zipcode = req.getParameter("zipcode");
		String delivery_message = req.getParameter("msg");
		String payment = req.getParameter("payment");

		// 2. 주문에 넣을 데이터들을 담을 큰 바구니 생성
		ShelfDAO dao = null;
		OrderDAO dao2 = null;
		
		List<OrderDTO> olist = new ArrayList<>();
		List<ShelfDTO> slist = new ArrayList<>();
		
		// 바로 구매인 경우
		if (buy_state == 1) {
			System.out.println("바로구매 서비스 수행중");
			
			String product_no = req.getParameter("product_no");
			int order_amount = Integer.parseInt(req.getParameter("amount"));
			
			OrderDTO dto = new OrderDTO();
			dto.setCustomer_id(customer_id);
			dto.setProduct_no(product_no);
			dto.setOrder_amount(order_amount);
			dto.setZipcode(zipcode);
			dto.setDelivery_message(delivery_message);
			dto.setPayment(payment);
		
			olist.add(dto);

		// 장바구니 구매인 경우
		} else if (buy_state == 2) {
			System.out.println("장바구니 구매 서비스 수행중");
			
			// 현재 고객의 장바구니 목록 조회
			dao = ShelfDAOImpl.getInstance();
			slist = dao.selectCartList(customer_id);
			
			// 큰 바구니에 담을 DTO를 생성하여 데이터를 등록 후 olist에 추가
			for (ShelfDTO shelf : slist) {	
				OrderDTO dto = new OrderDTO();
				dto.setCustomer_id(customer_id);
				dto.setProduct_no(shelf.getProduct_no());
				dto.setOrder_amount(shelf.getAmount());
				dto.setZipcode(zipcode);
				dto.setDelivery_message(delivery_message);
				dto.setPayment(payment);
				
				olist.add(dto);
			}
		}
		
		// 3. DAO를 생성하여 DB에서 주문목록을 등록한다.
		int insertResult = 0;
		dao2 = OrderDAOImpl.getInstance();
		insertResult = dao2.insertOrder(olist);
		
		// 2-2. 주문 등록에 성공하면 장바구니 내역 삭제
		int deleteResult = 0;
		if (buy_state == 2 && insertResult != 0) {
			deleteResult = dao.deleteCartAll();
		}
		
		// 3. request에 결과를 저장한다.
		req.setAttribute("insertResult", insertResult);
		req.setAttribute("deleteResult", deleteResult);
	}

//-------------------------------------- [ 상품리뷰 ] --------------------------------------------	

	@Override // 상품리뷰 등록
	public void insertReviewAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertReviewAction() 서비스 실행");
		
		// 1. 고객이 입력한 리뷰 내용과 정보들을 받아온다.
		ReviewDTO dto = new ReviewDTO();
		dto.setCustomer_id((String)req.getSession().getAttribute("sessionId"));
		dto.setReview_writer((String)req.getSession().getAttribute("sessionName"));
		dto.setReview_contents(req.getParameter("review"));
		dto.setProduct_no(req.getParameter("product_no"));
		dto.setReview_star(Integer.parseInt(req.getParameter("star")));
		
		// 2. DAO를 생성하여 DB에서 해당 리뷰번호의 리뷰를 등록한다.
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		int insertResult = dao.insertReview(dto);
		
		// 3. 결과를 request 객체에 저장한다.
		req.setAttribute("insertResult", insertResult);
		
		// 4. 해당 상품 상세로 돌아가기 위한 상품번호  request 객체에 저장
		req.setAttribute("product_no", req.getParameter("product_no"));
	}

	@Override // 상품리뷰 삭제
	public void deleteReviewAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteReviewAction() 서비스 실행");
		
		// 1. 리뷰 번호와 해당 리뷰가 있는 상품의 번호를 받아온다.
		String review_no = req.getParameter("review_no");
		String product_no = req.getParameter("product_no");
		System.out.println("product_no : " + product_no);
		
		// 2. DAO를 생성하고 DB에서 해당 리뷰번호에 대한 삭제를 처리한다.
		ReviewDAO dao = ReviewDAOImpl.getInstance();
		int deleteResult = dao.deleteReview(review_no);
		
		// 3. 리뷰삭제 결과와 리뷰가 있던 상품 번호를 request 객체에 저장한다.
		req.setAttribute("deleteResult", deleteResult);
		req.setAttribute("product_no", product_no);
	}
	
//-------------------------------------- [ 장바구니 ] --------------------------------------------	

	@Override // 장바구니 등록
	public void insertCartItemAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertCartAction() 서비스 실행");
		
		// 1. 상품번호와 수량을 받아옵니다.
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		String product_no = req.getParameter("product_no");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		ShelfDTO dto = new ShelfDTO();
		dto.setCustomer_id(customer_id);
		dto.setProduct_no(product_no);
		dto.setAmount(amount);
		
		// 2-1. DAO를 생성하여 장바구니에 동일한 상품이 있는지 확인합니다.
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		ShelfDTO oldDTO = dao.selectCartItem(customer_id, product_no);
		
		int insertResult = 0;
		int updateResult = 0;
		// 2-2. 있으면 기존 장바구니 상품의 수량만 증가시킵니다.
		if (oldDTO != null) {
			updateResult = dao.InsertDupCartItem(oldDTO.getShelf_no(), amount);
			req.setAttribute("updateResult", updateResult);
		
			// 2-2. 없는 경우, 장바구니 DB에 해당 정보를 새로 등록합니다.
		} else {
			
			insertResult = dao.insertCartItem(dto);
			req.setAttribute("insertResult", insertResult);
		}
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("product_no", product_no);
		
	}

	@Override // 장바구니 조회
	public void selectCartListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCartListAction() 서비스 실행");
		
		// 1. 현재 고객 아이디를 받아옵니다.
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		
		// 2. DAO를 생성하여 해당 고객의 장바구니를 DB에서 조회합니다.
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		List<ShelfDTO> slist = dao.selectCartList(customer_id);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("slist", slist);
		
	}

	@Override // 장바구니 수정
	public void updateCartItemAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateCartAction() 서비스 실행");
		
		// 1. 장바구니의 번호와 변경할 수량을 받아옵니다.
		String shelf_no = req.getParameter("shelf_no");
		int amount = Integer.parseInt(req.getParameter("amount"));
		System.out.println("shelf_no : " + shelf_no);
		System.out.println("amount : " + amount);
		
		// 2. DAO를 생성하여 해당 장바구니의 상품 수량을 DB에서 변경합니다.
		int updateResult = 0;
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		updateResult = dao.updateCartItemAmount(shelf_no, amount);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("updateResult", updateResult);
		
	}
	
	@Override // 장바구니 개별 삭제
	public void deleteCartItemAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCartAction() 서비스 실행");
		
		// 1. 장바구니의 번호들을 받아옵니다.
		String[] snList = req.getParameterValues("shelf_no");

		// 2. DAO를 생성하여 해당 장바구니를 DB에서 삭제합니다.
		int deleteResult = 0;
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		deleteResult = dao.deleteCartItem(snList);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("deleteResult", deleteResult);
	}
	
	@Override // 장바구니 비우기
	public void deleteCartAllAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteCartAllAction() 서비스 실행");
		
		// 1. DAO를 생성하여 장바구니를 DB에서 삭제합니다.
		int deleteResult = 0;
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		deleteResult = dao.deleteCartAll();
		
		// 2. request 객체에 결과를 저장합니다.
		req.setAttribute("deleteResult", deleteResult);
		
	}

	@Override// 장바구니 결제하기 페이지 이동
	public void buyCartProduct(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("buyCartProduct() 서비스 실행");
		
		// 1. 현재 로그인 고객의 아이디를 받아옵니다.
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		
		// 2. DAO를 생성하여 해당 유저의 장바구니 목록을 불러옵니다.
		ShelfDAO dao = ShelfDAOImpl.getInstance();
		List<ShelfDTO> slist = dao.selectCartList(customer_id);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("slist", slist);
		
	}

	@Override
	public void selectCustomerDeliveryInfo(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectCustomerAddress() 서비스 실행");
		
		// 1. 현재 로그인 고객의 아이디를 받아옵니다.
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		
		// 2-1. DAO를 생성하여 해당 고객의 zipcode를 받아옵니다.
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		String zipcode = dao.selectCustomerZipcode(customer_id);
		System.out.println("zipcode : " + zipcode);
		// 2-2. zipcode로 주소정보를 받아옵니다.
		ZipcodeDTO dto = dao.selectZipcodeInfo(zipcode);
		
		// 2-3. 고객의 정보를 받아옵니다.
		CustomerDTO dto2 = dao.selectCustomer(customer_id);

		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("z_dto", dto);
		req.setAttribute("c_dto", dto2);
		
	}
	
//-------------------------------------- [ 게시판 ] --------------------------------------------	

	@Override // 게시판 조회
	public void selectBoardListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectBoardListAction() 서비스 실행");
		
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

	@Override // 게시판 상세조회
	public void selectBoardDetailAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectBoardDetailAction() 서비스 실행");
		
		// 1. 게시글 번호를 받아온다.
		String board_no = req.getParameter("board_no");
		
		// 2. DAO 생성하여 DB에서 게시글을 조회하고, 결과를 받아온다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		BoardDTO dto = dao.selectBoardDetail(board_no);
		
		// 3. 결과를 request 객체에 저장하여 돌려준다.
		req.setAttribute("board", dto);
		
	}

	@Override // 게시판 등록
	public void insertBoardAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("insertBoardAction() 서비스 실행");
		
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

	@Override // 게시판 수정
	public void updateBoardAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("updateBoardAction() 서비스 실행");
		
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

	@Override // 게시판 삭제
	public void deleteBoardAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("deleteBoardAction() 서비스 실행");
		
		// 1. 게시글 번호를 받아옵니다.
		String board_no = req.getParameter("board_no");
		
		// 2. DAO를 생성하고, 해당 번호의 게시글을 DB에서 삭제합니다.
		BoardDAO dao = BoardDAOImpl.getInstance();
		int deleteResult = dao.deleteBoard(board_no);
		
		// 3. 결과를 request 객체에 저장합니다.
		req.setAttribute("deleteResult", deleteResult);
		
	}
	
//--------------------------------------- [ 주문 ] ---------------------------------------------

	@Override // 주문목록 조회
	public void selectOrderListAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectOrderListAction() 서비스 실행");
		
		// 1. 고객 아이디와 페이지번호를 받아옵니다.
		String customer_id = (String)req.getSession().getAttribute("sessionId");
		String pageNum = req.getParameter("pageNum");
		
		// 2. DAO를 생성하여 DB에서 주문목록을 조회합니다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		
		// 페이징 처리
		Paging paging = new Paging(pageNum);
		int total = dao.selectOrderTotal(customer_id);
		paging.setTotalCount(total);
		
		int start = paging.getStartRow();
		int end = paging.getEndRow();
		
		List<OrderDTO> olist = dao.selectOrderList(start, end, customer_id);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("paging", paging);
		req.setAttribute("olist", olist);
		
	}

	@Override // 주문 취소
	public void cancelOrderAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelOrderAction() 서비스 실행");
		
		// 1. 주문번호를 받아옵니다.
		String order_no = req.getParameter("order_no");
		String state = "주문취소";
		
		// 2. DAO를 생성하여 DB에서 해당 주문상태를 변경합니다.
		int updateResult = 0;
		OrderDAO dao = OrderDAOImpl.getInstance();
		updateResult = dao.updateState(order_no, state);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("updateResult", updateResult);
	}

	@Override // 환불
	public void refundAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("refundAction() 서비스 실행");
		
		// 1. 주문번호를 받아옵니다.
		String order_no = req.getParameter("order_no");
		String state = "환불요청";
		
		// 2. DAO를 생성하여 DB에서 해당 주문상태를 변경합니다.
		int updateResult = 0;
		OrderDAO dao = OrderDAOImpl.getInstance();
		updateResult = dao.updateState(order_no, state);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("updateResult", updateResult);
	}

	@Override // 환불 취소
	public void cancelRefundAction(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("cancelRefundAction() 서비스 실행");

		// 1. 주문번호를 받아옵니다.
		String order_no = req.getParameter("order_no");
		String state = "환불취소";
		
		// 2. DAO를 생성하여 DB에서 해당 주문상태를 변경합니다.
		int updateResult = 0;
		OrderDAO dao = OrderDAOImpl.getInstance();
		updateResult = dao.updateState(order_no, state);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("updateResult", updateResult);
		
	}

	@Override // 배송 상세조회
	public void selectDeliveryDetail(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("selectDeliveryDetail() 서비스 실행");
		
		// 1. 운송장번호를 받아옵니다.
		String billing_number = req.getParameter("billing_number");
		
		// 2-1. DAO를 생성하여 DB에서 배송 상세정보를 받아옵니다.
		OrderDAO dao = OrderDAOImpl.getInstance();
		List<DeliveryDTO> dlist = dao.selectDeliveryDetail(billing_number);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("dlist", dlist);
		
	}

	@Override // 바로구매시 넘겨줄 상품정보 조회
	public void buyProduct(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("buyProduct() 서비스 실행");
		
		// 1. 화면으로부터 상품번호와 구매수량을 받아옵니다.
		String product_no = req.getParameter("product_no");
		int amount = Integer.parseInt(req.getParameter("amount"));
		
		// 2. DAO를 생성하여 DB에서 상품정보를 저장합니다.
		ProductDAO dao = ProductDAOImpl.getInstance();
		ProductDTO p_dto = dao.selectProductDetail(product_no);
		
		// 3. request 객체에 결과를 저장합니다.
		req.setAttribute("p_dto", p_dto);
		req.setAttribute("amount", amount);
		
		
	}
}