package pj.mvc.jsp.dao;

import pj.mvc.jsp.dto.CustomerDTO;

public interface CustomerDAO {

	// 아이디 중복 확인
	int confirmId(String strId);
	
	// 회원정보 DB 등록
	int insertCustomer(CustomerDTO dto);

	// 로그인 회원 확인
	int loginCheck(String strId, String strPassword);
}