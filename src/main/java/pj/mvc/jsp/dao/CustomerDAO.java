package pj.mvc.jsp.dao;

import pj.mvc.jsp.dto.CustomerDTO;
import pj.mvc.jsp.dto.ZipcodeDTO;

public interface CustomerDAO {

	// 아이디 중복 확인
	int confirmId(String strId);
	
	// 회원정보 DB 조회
	CustomerDTO selectCustomer(String strId);
	
	// 회원정보 DB 등록
	int insertCustomer(CustomerDTO dto);
	
	// 회원정보 DB 수정
	int updateCustomer(CustomerDTO dto);
	
	// 회원정보 DB 삭제
	int deleteCustomer(String strId);
	
	// 아이디, 비밀번호 체크
	int idPasswordCheck(String strId, String strPassword);

	// 회원 우편번호 가져오기
	String selectCustomerZipcode(String strId);

	// 주소정보 가져오기
	ZipcodeDTO selectZipcodeInfo(String zipcode);
	
}