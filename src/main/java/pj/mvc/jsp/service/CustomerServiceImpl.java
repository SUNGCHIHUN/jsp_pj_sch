package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	
	public CustomerServiceImpl() {}

	@Override
	public int confirmIdAction(HttpServletRequest req, HttpServletResponse res) {
		// 아이디 중복확인 결과
		int dupChk = 0;
		
		// 입력받은 아이디값
		String strId = req.getParameter("id");
		
		// DB에서 아이디 중복 조회 및 결과 저장
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		dupChk = dao.confirmId(strId);
		
		// 결과 반환 (중복 = 1, 신규 = 0)
		return dupChk;
	}

	@Override
	public int registerAction(HttpServletRequest req, HttpServletResponse res) {
		// 회원가입 결과
		int registerResult = 0;
		
		// 회원가입 데이터를 dto에 저장
		CustomerDTO dto = new CustomerDTO();
		dto.setCustomer_id(req.getParameter("id"));
		dto.setCustomer_password(req.getParameter("password"));
		dto.setCustomer_name(req.getParameter("name"));
		
		String email = req.getParameter("email1") + "@" + req.getParameter("email2");
		dto.setCustomer_email(email);

		String tel = req.getParameter("tel1") + "-" + req.getParameter("tel1") + "-" + req.getParameter("tel1");
		dto.setCustomer_tel(tel);
		dto.setZipcode(req.getParameter("zipcode"));
		dto.setCustomer_address(req.getParameter("address2"));
		
		// DB에서 회원가입 수행
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		registerResult = dao.insertCustomer(dto);
		
		return registerResult;
	}

	@Override
	public int loginAction(HttpServletRequest req, HttpServletResponse res) {
		
		return 0;
	}
}