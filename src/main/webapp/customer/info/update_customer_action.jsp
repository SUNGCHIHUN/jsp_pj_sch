<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정 처리</title>
<script src="<%=request.getContextPath() %>/resources/js/common/alert_error.js"></script>
</head>
<body>
	<%
		// 회원정보 수정을 성공하면
		if ((Integer)request.getAttribute("updateResult") == 1) {
	%>
			<script>
				alert("회원정보가 수정되었습니다.");
				window.location="<%=request.getContextPath() %>/customer_info.do";
			</script>
	<%
			
		// 회원정보 수정을 실패하면
		} else {
	%>
			<script>
				errorAlert(updateError);
				window.history.back();
			</script>
	<%
		}
	%>
</body>
</html>