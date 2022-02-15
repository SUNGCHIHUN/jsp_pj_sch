<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복 확인</title>
<script src="<%=request.getContextPath() %>/resources/js/customer/register.js" defer></script>
</head>
<body>
	<h2> 아이디 중복 확인</h2>
	<form action="<%=request.getContextPath() %>/confirm_id_action.do" name="confirm_form" method="post"
				onsubmit="return confirmIdCheck();">
	<% 
		String strId = (String)request.getAttribute("strId");
		int dupChk = (Integer)request.getAttribute("dupChk"); 	
	%>
	<%
		// 중복된 아이디인 경우
		if (dupChk == 1) {
	%>		<table>
				<tr>
					<th colspan="2">'<%=strId %>'는 사용할 수 없습니다.</th>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="submit" value="확인">
						<input type="reset" value="취소" onclick="self.close();">
					</th>
				</tr>
			</table>
	<%		
		// 중복되지 않은 경우
		} else {
	%>		<table>
				<tr>
					<th colspan="2">'<%=strId %>'는 사용 가능합니다.</th>
				</tr>
				<tr>
					<th colspan="2">
						<input type="button" value="확인" onclick="setId('<%=strId %>')">
					</th>
				</tr>
			</table>
	<%	
		}
	%>
	</form>
</body>
</html>