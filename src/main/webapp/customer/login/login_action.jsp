<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
</head>
<body>
	<%
		// 로그인 체크 결과[성공:1, 실패:0]
		int loginResult = (Integer)request.getAttribute("loginResult");

		// 로그인 성공
		if (loginResult == 1) {
			response.sendRedirect(request.getContextPath() + "/main.do");
		
		// 로그인 실패[비밀번호 오류]
		} else if (loginResult == -1){
			response.sendRedirect(request.getContextPath() + "/login.do?loginResult=" + loginResult);
		
		// 로그인 오류
		} else {
			response.sendRedirect(request.getContextPath() + "/login.do?loginResult=" + loginResult);
		}
	%>
</body>
</html>