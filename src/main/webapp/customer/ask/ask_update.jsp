<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>치모 문의수정</title>
<link href="<%=request.getContextPath() %>/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../../common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> 문의사항 수정 </h1>
			<hr>
			<div class="board">
				<table>
					<tr>
						<th> 제목 </th>
						<td colspan="2"><input type="text" size="50" value="회원가입은 어떻게 하는 건가요?"></td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<td>홍길동 </td>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<textarea name="content" cols="120" rows="20">
회원가입을 하고 싶은데 어떻게 해야 좋을 지 모르겠습니다.
							</textarea>
						</td>
					</tr>
			
					<tr>
						<td colspan="3">
							<a href="<%=request.getContextPath() %>/ask_update_action.do">수정</a> &nbsp;
							<a href="<%=request.getContextPath() %>/ask_detail.do">취소</a>
						</td>	
					</tr>
				</table>
			</div>
		</div>
	</div>
	<%@ include file="../../common/footer.jsp" %>
</body>
</html>