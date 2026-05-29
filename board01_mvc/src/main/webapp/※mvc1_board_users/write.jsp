<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<div class="container card my-5">
	<h3 class="card-header">글 등록</h3>
	<form action="write_action.jsp" method="post" onsubmit="return check()">
		<div class="my-3">
			<label for="bname">글쓴이</label> <input type="text"
				class="form-control" id="bname" name="bname" />
		</div>
		<div class="my-3">
			<label for="bpass">비밀번호</label> <input type="password"
				class="form-control" id="bpass" name="bpass" />
		</div>
		<div class="my-3">
			<label for="btitle">제목</label> <input type="text"
				class="form-control" id="btitle" name="btitle" />
		</div>
		<div class="my-3">
			<label for="bcontent">내용</label>
			<textarea class="form-control" id="bcontent" name="bcontent"> </textarea>
		</div>
		<div class="my-3">
			<button type="reset" class="btn btn-dark" title="글 취소">취소</button>
			<a href="list.jsp" class="btn btn-dark" title="목록 보러가기">목록으로</a>
			<button type="submit" class="btn btn-dark" title="글 등록하기">글쓰기</button>
		</div>
	</form>
</div>

<script>
	function check() {
		let bname = document.getElementById("bname");
		let bpass = document.getElementById("bpass");
		let btitle = document.getElementById("btitle");
		let bcontent = document.getElementById("bcontent");

		if (bname.value.trim() == "") {
			alert("이름을 작성해주세요.");
			bname.focus();
			return false;
		}
		if (bpass.value.trim() == "") {
			alert("비밀번호를 작성해주세요.");
			bpass.focus();
			return false;
		}
		if (btitle.value.trim() == "") {
			alert("제목을 작성해주세요.");
			btitle.focus();
			return false;
		}
		if (bcontent.value.trim() == "") {
			alert("내용을 작성해주세요.");
			bcontent.focus();
			return false;
		}
		return true;
	}
</script>

<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>