<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ko_category}</title>
<link href="${path}/resources/css/common/page.css" rel="stylesheet">
<link href="${path}/resources/css/common/board2.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/common/header.jsp" %>
	<div id="container">
		<div id="section">
			<h1 align="center"> ${ko_category} </h1>
			<hr>
			<div class="board">
				<form action="${path}/board_update.do?board_no=${board.board_no}" method="post">
					<table>
						<tr>
							<th>제목</th>
							<td colspan="2">${board.board_title}</td>
						</tr>
						
						<tr>
							<th>작성자</th>
							<td>${board.board_writer}</td>
							<td style="text-align: right;">${board.board_regist_day}</td>
						</tr>
						
						<tr>
							<th>내용</th>
							<td colspan="2">
								<br>
								${board.board_contents}
							</td>
						</tr>
						
						<%-- 문의사항인 경우 답변 창 표시 --%>
						<c:if test="${board.board_category == 'ask'}">
							<tr>
								<th>답변</th>
								<td>회원가입 버튼을 누르고 가입하면 됩니다.</td>
								<td style="text-align: right;">
									<ul style="text-align: right;">
										<li>관리자</li>
										<li>(2022-01-25)</li>
									</ul>
								</td>
							</tr>
						</c:if>
						<tr>
							<td>
								<a href="${path}/board_list.do?board_category=${board.board_category}">목록</a>
							</td>
							
							<%-- 문의사항 게시판인 경우 --%>
							<c:choose>
								<c:when test="${board.board_category == 'ask'}">
									<%-- 로그인한 유저의 아이디와 게시글 작성한 아이디가 동일하면 --%>	
									<c:if test="${sessionId == board.customer_id}">
										<td colspan="2">
											<input type="submit" value="수정">
											<input type="button" value="삭제" onclick="window.location='${path}/board_delete_action.do?board_no=${board.board_no}&board_category=${board.board_category}'">
										</td>	
									</c:if>
								</c:when>
								<c:otherwise></c:otherwise>
							</c:choose>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
	<%@ include file="/common/footer.jsp" %>
</body>
</html>