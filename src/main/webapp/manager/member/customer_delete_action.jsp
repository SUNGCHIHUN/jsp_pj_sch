<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 처리</title>
</head>
<body>
	<%-- 회원탈퇴 성공 --%>
	<c:if test="${updateResult != 0}">
		<script>
			alert("회원을 탈퇴처리하였습니다!");
			window.location="${path}/customer_list.ad?pageNum=${pageNum}";
		</script>
	</c:if>

	<%-- 회원탈퇴 실패 --%>
	<c:if test="${updateResult == 0}">
		<script>
			alert("회원탈퇴처리 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>