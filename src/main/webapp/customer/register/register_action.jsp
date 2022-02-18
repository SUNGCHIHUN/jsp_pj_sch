<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 처리중...</title>
</head>
<body>
	<c:if test="${registerResult == 1}">
		<script>
			alert("회원가입에 성공하였습니다.");
			window.location="${path}/login.do";
		</script>
	</c:if>
	
	<c:if test="${registerResult != 1}">
		<script>
			alert("회원가입에 실패하였습니다.");
			window.history.back();
		</script>
	</c:if>
</body>
</html>