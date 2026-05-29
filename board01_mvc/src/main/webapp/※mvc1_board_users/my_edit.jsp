<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<%
	String bpass="", mobile = "", udate = "", bip = "";
	
	if (email == null) {
	    response.sendRedirect("login.jsp");
	    return;
	}
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where email=? and nickname=?";
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email); 
		pstmt.setString(2, nickname);
		
		rset = pstmt.executeQuery();
		
		while(rset.next()){
			mobile = rset.getString("mobile");
			udate = rset.getString("udate");
			bip = rset.getString("bip");
		}
		
		// 3. 끊기
		if(rset  != null){ rset.close();  }
		if(pstmt != null){ pstmt.close(); }
		if(conn  != null){ conn.close();  }
		
	} catch(Exception e){ e.printStackTrace();}
	
%>
	<section class="container my-5">
		<div class="container card my-5">
			<h3 class="card-header">정보 수정하기</h3>
			<form action="my_edit_action.jsp" method="post" onsubmit="return check()">
				<div class="my-3">
					<label for="nickname">닉네임</label> <input type="text"
						class="form-control" value='<%=nickname%>' id="nickname" name="nickname" />
				</div>
				<div class="my-3">
					<label for="email">이메일</label> <input type="text"
						class="form-control" value='<%=email%>' id="email" name="email" readonly />
				</div>
				<div class="my-3">
					<label for="mobile">휴대폰</label> <input type="text"
						class="form-control" value='<%=mobile%>' id="mobile" name="mobile"/>
				</div>
				<div class="my-3">
					<label for="mobile">가입일</label> <input type="text"
						class="form-control" value='<%=udate%>' id="udate" name="udate" readonly />
				</div>			
				<div class="my-3">
					<label for="bpass">비밀번호</label> <input type="password"
						class="form-control" placeholder="기존 비밀번호 입력" id="bpass" name="bpass"/>
				</div>
				<div class="my-3">
					<button type="reset" class="btn btn-dark" title="수정 취소">취소</button>
					<button type="submit" class="btn btn-dark" title="글 수정하기">수정</button>
				</div>
			</form>
		</div>
	</section>
	<script>
		function check(){
			let nickname = document.getElementById("nickname");
			let mobile = document.getElementById("mobile");
			let bpass = document.getElementById("bpass");
			
			if(nickname.value.trim()==""){
				alert("닉네임을 입력해주세요");
				nickname.focus();
				return false;
			}
			if(mobile.value.trim()==""){
				alert("휴대폰번호를 입력해주세요");
				mobile.focus();
				return false;
			}
			if(bpass.value.trim()==""){
				alert("비밀번호를 입력해주세요");
				bpass.focus();
				return false;
			}
		}
	</script>


<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>