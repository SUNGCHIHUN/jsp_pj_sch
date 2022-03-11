<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 삭제처리</title>
</head>
<body>
	<%-- 리뷰삭제 성공 --%>
	<c:if test="${deleteResult == 1}">
		<script>
			alert("리뷰가 삭제되었습니다.");
			window.location='${path}/review_list.do?pageNum=${pageNum}';
		</script>
	</c:if>
	
	<%-- 리뷰삭제 실패 --%>
	<c:if test="${deleteResult != 1}">
		<script>
			alert("리뷰 삭제 실패");
			window.location='${path}/review_list.do?pageNum=${pageNum}';
		</script>
	</c:if>
</body>
</html>