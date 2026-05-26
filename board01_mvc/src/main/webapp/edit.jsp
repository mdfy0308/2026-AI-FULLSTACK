<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<% 
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	String bname = "", bpass="", btitle = "", bcontent = "";

	try{
		// 1. 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from mvcboard1 where bno="+ bno;
		conn = DriverManager.getConnection(url, "root", "1234");
       	pstmt = conn.prepareStatement(sql);
		
		// 2. 내용을 불러와서 보여주고 > 수정하기 버튼 누르면 action으로 처리하기
       	rset = pstmt.executeQuery(); 
       	
       	while(rset.next()){
       		bname = rset.getString("bname");
       		bpass = rset.getString("bpass");
       		btitle = rset.getString("btitle");
       		bcontent = rset.getString("bcontent");
       	}
    
       	// 끊기
       	if(rset  != null){ rset.close(); }
       	if(pstmt != null){ pstmt.close(); }
       	if(conn  != null){ conn.close(); }
		
	} catch( Exception e ){ e.printStackTrace(); }

%>

	<div class="container card my-5">
		<h3 class="card-header">글 수정</h3>
		<form action="edit_action.jsp?bno=<%=bno%>" method="post" onsubmit="return check()">
			<div class="my-3">
				<label for="bname">글쓴이</label> <input type="text"
					class="form-control" value='<%=bname %>' id="bname" name="bname" readonly/>
			</div>
			<div class="my-3">
				<label for="bpass">비밀번호</label> <input type="password"
					class="form-control" placeholder="비밀번호 입력" id="bpass" name="bpass" />
			</div>
			<div class="my-3">
				<label for="btitle">제목</label> <input type="text"
					class="form-control" value='<%=btitle %>' id="btitle" name="btitle"/>
			</div>
			<div class="my-3">
				<label for="bcontent">내용</label>
				<textarea class="form-control" id="bcontent" name="bcontent" > <%=bcontent %> </textarea>
			</div>
			<div class="my-3">
				<button type="reset" class="btn btn-dark" title="글 취소">취소</button>
				<a href="list.jsp" class="btn btn-dark" title="목록 보러가기">목록</a>
				<button typr="submit" class="btn btn-dark" title="글 수정하기">글수정</button>
			</div>
		</form>
	</div>
		
	<script>
		function check(){
			let bpass = document.getElementById("bpass");
			let btitle = document.getElementById("btitle");
			let bcontent = document.getElementById("bcontent");

			if(bpass.value.trim()==""){
				alert("비밀번호를 작성해주세요.");
				bpass.focus();
				return false;
			}
			if(btitle.value.trim()==""){
				alert("제목을 작성해주세요.");
				btitle.focus();
				return false;
			}
			if(bcontent.value.trim()==""){
				alert("내용을 작성해주세요.");
				bcontent.focus();
				return false;
			}
			return true;
		}
	</script>

	<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>