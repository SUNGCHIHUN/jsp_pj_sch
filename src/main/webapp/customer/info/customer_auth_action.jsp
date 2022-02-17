<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증 처리</title>
<script src="<%=request.getContextPath() %>/resources/js/common/alert_error.js"></script>
</head>
<body>
<%
	// 인증이 안되어 있는 경우
	if ((Integer)request.getSession().getAttribute("authResult") == 0) {
		// 비밀번호가 맞는 경우
		if ((Integer)request.getAttribute("loginResult") == 1) {
			// 인증 성공 1 설정
			request.getSession().setAttribute("authResult", 1);
			response.sendRedirect(request.getContextPath() + "/customer_info.do");
		} else {
		%>
			<script>
				errorAlert(passwordError);
				history.go(-1);
			</script>
		<%	
		}
	// 인증을 성공한 경우
	} else {
		response.sendRedirect(request.getContextPath() + "/customer_info.do");
	}

%>			
</body>
</html>