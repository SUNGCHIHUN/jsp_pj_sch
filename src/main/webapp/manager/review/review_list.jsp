<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 리뷰목록</title>
<link rel="stylesheet" href="${path}/resources/css/manager/main.css">
<link rel="stylesheet" href="${path}/resources/css/manager/board_list.css">
<link rel="stylesheet" href="${path}/resources/css/manager/page.css">
<script>
	function deleteReview(no) {
		if (confirm('리뷰를 삭제하시겠습니까?')) {
			window.location='${path}/review_delete_action.ad?review_no=' + no;
		}
	}
</script>
</head>
<body>
	<!-- header -->
	<%@ include file="/manager/common/header.jsp" %>
	<div id="container">
		<!-- 메뉴이름 -->
		<div id="title">
			<h1>리뷰목록</h1>
		</div>
		
		<div id="contents">
			<!-- 왼쪽 메뉴 -->
			<%@ include file="/manager/common/left_menu.jsp" %>
			<div id="section">
				<table>
					<tr>
						<th width="5%">번호</th>
						<th width="10%">작성자</th>
						<th width="10%">내용</th>
						<th width="10%">별점</th>
						<th width="10%">작성일</th>
						<th width="10%">관리</th>
					</tr>
					<c:forEach var="r" items="${rlist}" varStatus="status">
						<tr>
							<td>${r.review_no}</td>
							<td>${r.review_writer}</td>
							<td>${r.review_content}</td>
							<td>
								<c:choose>
									<c:when test="${review_star == 5}">★★★★★</c:when>
									<c:when test="${review_star == 4}">★★★★☆</c:when>
									<c:when test="${review_star == 3}">★★★☆☆</c:when>
									<c:when test="${review_star == 2}">★★☆☆☆</c:when>
									<c:when test="${review_star == 1}">★☆☆☆☆</c:when>
									<c:otherwise> 없음 </c:otherwise>
								</c:choose>
							</td>
							<td>${r.review_regist_day}</td>
							<td id="btn_td">
								<input type="button" name="btnDelete" value="삭제" onclick="deleteReview(${r.review_no})">
							</td>
						</tr>
					</c:forEach>
					<%-- 페이징 처리 --%>
					<tr>
						<td colspan="8" align="center" style="border-bottom: none;">
							<%-- 이전버튼 활성화 여부 --%>
							<c:if test="${paging.startPage > 10}">
								<a href="${path}/review_list.ad?pageNum=${paging.prev}">[이전]</a>
							</c:if>
							
							<%-- 페이지 번호 처리 --%>
							<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
								<%-- 현재 페이지 번호는 눌리지 않게 처리 --%>
								<c:if test="${num == paging.currentPage}">
									<span style="font-weight: bold;">${num}</span>
								</c:if>
								
								<c:if test="${num != paging.currentPage}">
									<a href="${path}/review_list.ad?pageNum=${num}">${num}</a>
								</c:if>
								
							</c:forEach>
							
							<%-- 다음버튼 활성화 여부 --%>
							<c:if test="${paging.endPage < paging.pageCount}">
								<a href="${path}/review_list.ad?pageNum=${paging.next}">[다음]</a>
							</c:if>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>	
	<!-- footer -->
	<%@ include file="/manager/common/footer.jsp" %>
</body>
</html>