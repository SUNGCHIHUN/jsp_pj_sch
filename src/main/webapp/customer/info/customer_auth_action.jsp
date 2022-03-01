<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증 처리</title>
<script src="${path}/resources/js/common/alert_error.js"></script>
</head>
<body>
	<%-- 인증이 안되어 있는 경우 --%>
	<c:if test="${authResult == 0}">
		<%-- 비밀번호가 일치하는 경우 --%>
		<c:if test="${loginResult == 1}">
			<c:set var="authResult" value="1" scope="session" />
			<c:redirect url="customer_info.do" />
		</c:if>
		
		<%-- 비밀번호가 일치하지 않는 경우 --%>
		<c:if test="${loginResult != 1}">
			<script>
				errorAlert(passwordError);
				history.go(-1);
			</script>
		</c:if>
	</c:if>
	
	<%-- 인증을 성공한 경우 --%>
	<c:if test="${authResult == 1}">
		<c:redirect url="customer_info.do" />
	</c:if>
	
	
<%
	// 인증이 안되어 있는 경우
	if ((Integer)request.getSession().getAttribute("authResult") == 0) {
		// 비밀번호가 맞는 경우
		if ((Integer)request.getAttribute("loginResult") == 1) {
			// 인증 성공 1 설정
			/* request.getSession().setAttribute("authResult", 1); */
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