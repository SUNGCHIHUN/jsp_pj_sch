<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃 처리</title>
</head>
<body>
	<%
		// 세션 해제 후 메인으로 이동
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/main.do");
	%>
</body>
</html>