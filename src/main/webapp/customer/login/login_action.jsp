<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 처리</title>
<script src="${path}/resources/js/common/alert_error.js"></script>
</head>
<body>
	<c:choose>
		<%-- 로그인 성공 --%>
		<c:when test="${loginResult == 1}">
			<script>
				alert("로그인되었습니다.");
				window.location="${path}/main.do";
			</script>
		</c:when>
		
		<%-- 로그인 실패[비밀번호 오류] --%>
		<c:when test="${loginResult == -1}">
			<c:redirect url="login.do?loginResult=${loginResult}" />
		</c:when>
		
		<%-- 로그인 오류 --%>
		<c:otherwise>
			<c:redirect url="login.do?loginResult=${loginResult}" />
		</c:otherwise>
	</c:choose>
</body>
</html>