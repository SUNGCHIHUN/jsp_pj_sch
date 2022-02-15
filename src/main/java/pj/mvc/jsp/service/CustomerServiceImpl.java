package pj.mvc.jsp.service;

import pj.mvc.jsp.dao.CustomerDAO;
import pj.mvc.jsp.dao.CustomerDAOImpl;
import pj.mvc.jsp.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	
	public CustomerServiceImpl() {
		
	}
	
	@Override
	public int loginCheck(String strId, String strPassword) {
		return 0;
	}

	@Override
	public int idCheck(String strId) {
		
		// 아이디 중복확인 결과
		int dupChk = 0;
		
		// DB에서 아이디 중복 조회 및 결과 저장
		CustomerDAO dao = CustomerDAOImpl.getInstance();
		dupChk = dao.confirmId(strId);
		
		// 결과 반환 (중복 = 1, 신규 = 0)
		return dupChk;
	}

	@Override
	public int insertCustomer(CustomerDTO dto) {
		return 0;
	}
	
}