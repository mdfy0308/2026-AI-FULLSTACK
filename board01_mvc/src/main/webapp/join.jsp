<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>

<% if(email != null){ out.println("<script>alert('먼저 로그아웃해주세요.'); history.go(-1); </script>"); } %>

<!-- header-->

   <div class="container card my-5">
      <h3 class="card-header">회원가입</h3>
      
      <form action="join_action.jsp" method="post" onsubmit="return check()">
      	<div class="my-3">
      		<label for="nickname">닉네임</label>
      		<input type="text" class="form-control" id="nickname" name="nickname" />
      	</div>
      	<div class="my-3">
      		<label for="bpass">비밀번호</label>
      		<input type="password" class="form-control" id="bpass" name="bpass" />
      	</div>
      	<div class="my-3">
      		<label for="email">이메일</label>
      		<input type="text" class="form-control" id="email" name="email" />
      	</div>
      	<div class="my-3">
      		<label for="">휴대폰</label>
      		<input type="text" class="form-control" id="mobile" name="mobile" />
      	</div>
      	<div class="my-3">
			<a href="list.jsp" class="btn btn-dark" title="취소하기">취소</a>
			<button type="submit" class="btn btn-dark" title="가입하기">가입하기</button>
		</div>
      </form>
   </div>
   
   <script>	
		function check(){
			let nickname = document.getElementById("nickname");
			let bpass = document.getElementById("bpass");
			let email = document.getElementById("email");
			let mobile = document.getElementById("mobile");
			
			if(nickname.value.trim() == ""){
				alert("닉네임을 입력하세요.");
				nickname.focus();
				return false;
			}
			if(bpass.value.trim() == ""){
				alert("비밀번호를 입력하세요.");
				bpass.focus();
				return false;
			}
			if(email.value.trim() == ""){
				alert("이메일을 입력하세요.");
				email.focus();
				return false;
			}
			if(mobile.value.trim() == ""){
				alert("휴대폰 번호를 입력하세요.");
				mobile.focus();
				return false;
			}
		}
   
   </script>
   
  
<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>