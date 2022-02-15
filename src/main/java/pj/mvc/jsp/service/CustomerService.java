package pj.mvc.jsp.service;

import pj.mvc.jsp.dto.CustomerDTO;

public interface CustomerService {

	// 로그인 처리
	int loginCheck(String strId, String strPassword);
	
	// 아이디 중복 체크
	int idCheck(String strId);
	
	// 회원가입 처리
	int insertCustomer(CustomerDTO dto);
	
}
