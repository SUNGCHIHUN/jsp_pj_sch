<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${param.ko_category} 등록</title>
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> ${param.ko_category} 등록 </h1>
			<hr>
			<div class="board">
				<form action="${path}/board_add_action.do?board_category=${param.board_category}" method="post">
				<table>
					<tr>
						<th> 제목 </th>
						<td colspan="2"><input type="text" class="inputTitle" name="title"></td>
					</tr>
					
					<tr>
						<th>작성자</th>
						<c:if test="${sessionId != ''}">
							<td>홍길동</td>
						</c:if>
						<c:if test="${sessionId == ''}">
							<td>비회원</td>
						</c:if>
					</tr>
					
					<tr>
						<th>내용</th>
						<td colspan="2">
							<textarea name="contents" cols="120" rows="20"></textarea>
						</td>
					</tr>
					<tr>
						<th>파일</th>
						<td colspan="2">
							<input type="file" accept="image/*,.txt">
						</td>
					</tr>
					<tr>
						<td colspan="3">
							<input type="submit" value="등록">
							<input type="button" value="취소" onclick="history.go(-1);">
						</td>	
					</tr>
				</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>