<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
%>

<div class="container card my-5">
	<h3 class="card-header">글을 삭제하시겠습니까?</h3>
	<form action="delete_action.jsp?bno=<%=bno%>" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="bpass">비밀번호</label> <input type="password"
				class="form-control" placeholder="비밀번호를 입력해주세요." id="bpass"
				name="bpass" />
		</div>
		<div class="my-3">
			<button type="reset" class="btn btn-dark" title="글 취소">취소</button>
			<a href="list.jsp" class="btn btn-dark" title="목록 보러가기">목록으로</a>
			<button type="submit" class="btn btn-dark" title="글 삭제하기">글삭제</button>
		</div>
	</form>
</div>

<script>
	function check() {
		let bpass = document.getElementById("bpass");

		if (bpass.value.trim() == "") {
			alert("비밀번호를 입력해주세요.");
			bpass.focus();
			return false;
		}
		return true;
	}
</script>

<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>