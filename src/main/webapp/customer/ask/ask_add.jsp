<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 문의등록</title>
<link href="<%=request.getContextPath() %>/resources/css/common/page.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> 문의사항 등록 </h1>
			<hr>
			<div class="board">
				<table>
					<tr>
						<th> 제목 </th>
						<td colspan="2"><input type="text" class="inputTitle"></td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<td>홍길동 </td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<textarea name="content" cols="120" rows="20"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<a href="<%=request.getContextPath() %>/ask_add_action.do">등록</a>&nbsp;
							<a href="<%=request.getContextPath() %>/ask_list.do">취소</a>
						</td>	
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>