package pj.mvc.jsp.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CustomerService {

	// 아이디 중복 체크
	int confirmIdAction(HttpServletRequest req, HttpServletResponse res);
	
	// 회원가입 처리
	int registerAction(HttpServletRequest req, HttpServletResponse res);
	
	// 로그인 처리
	int loginAction(HttpServletRequest req, HttpServletResponse res);
}