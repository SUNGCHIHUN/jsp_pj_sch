	/**
 * 상품 상세 자바스크립트
 */

function addCart() {
	alert("장바구니에 담겼습니다.");
}

function pay() {
	
}

function deleteReview() {
	if(confirm("리뷰를 삭제하시겠습니까?")) {
		window.location.href='${path}' + "/delete_review_action.do";
	}
}