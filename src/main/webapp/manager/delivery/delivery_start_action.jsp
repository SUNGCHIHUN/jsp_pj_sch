<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송시작 처리</title>
</head>
<body>
	<%-- 배송시작 성공 --%>
	<c:if test="${updateResult != 0}">
		<script>
			alert("배송을 시작하였습니다!");
			window.location="${path}/delivery_list.ad?pageNum=${pageNum}";
		</script>
	</c:if>

	<%-- 배송시작 실패 --%>
	<c:if test="${updateResult == 0}">
		<script>
			alert("배송시작 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>