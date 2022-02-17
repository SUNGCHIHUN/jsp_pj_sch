<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증 처리</title>
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
		<div id="container">
		<div id="section1">
			<div class="section_menu">
				<ul>
					<li><a href="<%=request.getContextPath() %>/customer_auth_action.do"><b>회원정보</b></a></li>
					<li><a href="<%=request.getContextPath() %>/order_list.do">주문목록</a></li>
				</ul>
			</div>
		</div>	
		<div id="section2">
		<%
			// 인증을 한 적이 없는 경우
			if ((Integer)request.getAttribute("authResult") == 0) {
				
			// 인증을 한 적이 있는 경우
			} else {
				response.sendRedirect(request.getContextPath() + "/customer_info.do");
			}
		
		%>			
		</div>
	</div>
	
	
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>