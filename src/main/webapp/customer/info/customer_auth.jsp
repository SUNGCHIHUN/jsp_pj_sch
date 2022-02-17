<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증</title>
<link href="<%=request.getContextPath() %>/resources/css/customer/customer_auth.css" rel="stylesheet">
<script src="<%=request.getContextPath() %>/resources/js/common/alert_error.js"></script>
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
			// 로그인을 하지 않은 경우
			if (((String)request.getSession().getAttribute("sessionId")).equals("")) {
		%>
					<script>
						errorAlert(needLoginError);
						window.location="<%=request.getContextPath() %>/login.do";
					</script>
		<%
			// 로그인을 한 경우
			} else {
				// 인증을 한 적이 없는 경우
				
				if ((Integer)request.getSession().getAttribute("authResult") == 0) {
		%>
				<div class="logo">
					
				</div>
				<div class="customer_auth">
					<form action="customer_auth_action.do" method="post">
						<table>
							<tr>
								<th colspan="2"><img src="<%=request.getContextPath() %>/resources/images/navImage/logo.png" alt="로고"></th>
							</tr>
							<tr>
								<th colspan="2"><%=(String)request.getSession().getAttribute("sessionId") %>님의 비밀번호를 한번 더 입력해 주세요.</th>
							</tr>
							<tr>
								<td colspan="2"><input type="password" class="inputBox" name="password" autofocus required></td>
							</tr>
							<tr>						
								<td>
									<input type="submit" class="confirmBtn"value="확인">
									<input type="button" class="cancelBtn" value="취소" onclick="history.go(-1);">
								</td>
							</tr>
						</table>
					</form>
				</div>
		<%
				// 인증을 한 적이 있는 경우
				} else {
					response.sendRedirect(request.getContextPath() + "/customer_info.do");
				}
			}
		%>				
		</div>
	</div>	
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>