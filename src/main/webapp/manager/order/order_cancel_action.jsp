<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문취소 처리</title>
</head>
<body>
	<%-- 주문취소 성공 --%>
	<c:if test="${updateResult != 0}">
		<script>
			alert("주문을 취소하였습니다!");
			window.location="${path}/order_list.ad?pageNum=${pageNum}";
		</script>
	</c:if>

	<%-- 주문취소 실패 --%>
	<c:if test="${updateResult == 0}">
		<script>
			alert("주문취소 실패");
			history.go(-1);
		</script>
	</c:if>
</body>
</html>