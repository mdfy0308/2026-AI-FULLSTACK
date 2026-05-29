<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

   <div class="container card my-5">
      <h3 class="card-header">로그인</h3>
      <form action="login_action.jsp" method="post" onsubmit="return check()">
     	 <div class="my-3">
      		<label for="email">이메일</label>
      		<input type="text" class="form-control" placeholder="이메일을 입력하세요." id="email" name="email" />
      	</div>
      	<div class="my-3">
      		<label for="bpass">비밀번호</label>
      		<input type="password" class="form-control" placeholder="비밀번호를 입력하세요."id="bpass" name="bpass" />
      	</div>
      	<div class="my-3">
			<a href="list.jsp" class="btn btn-dark" title="취소하기">취소</a>
			<button type="submit" class="btn btn-dark" title="로그인하기">로그인</button>
		</div>
      </form>
   </div>
   <script>
		function check() {
			let email = document.getElementById("email");
			let bpass = document.getElementById("bpass");
	
			if (email.value.trim() == "") {
				alert("이름을 작성해주세요.");
				email.focus();
				return false;
			}
			if (bpass.value.trim() == "") {
				alert("비밀번호를 작성해주세요.");
				bpass.focus();
				return false;
			}
			
			return true;
		}
	</script>
  
<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>