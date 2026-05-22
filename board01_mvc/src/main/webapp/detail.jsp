<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	int bhit = 0;
	String bname = "", btitle = "", bcontent = "";

	try {
		// 1. 연동~구문
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from mvcboard1 where bno=" + bno;
		String update = "update mvcboard1 set bhit= bhit+1 where bno=" + bno;
		
		conn = DriverManager.getConnection(url, "root", "1234");
       	pstmt = conn.prepareStatement(update);
       
       	// 1. 조회수 업데이트하기
       	pstmt.executeUpdate();
       	
       	// 2. 값 넣기
       	pstmt = conn.prepareStatement(sql);
       	rset = pstmt.executeQuery();
       	
       	while( rset.next() ){
       		bname = rset.getString("bname");
           	btitle = rset.getString("btitle");
           	bcontent = rset.getString("bcontent");
           	bhit = rset.getInt("bhit");
       	}
       	
		// 2. 끊기
       	if(rset != null){ rset.close(); }
       	if(pstmt != null){ pstmt.close(); }
       	if(conn != null){ conn.close(); }
		
	} catch( Exception e ){ e.printStackTrace(); }
	
%>

	<div class="container card my-5">
		<h3 class="card-header">글 상세보기</h3>
		<form action="#" method="post">
			<div class="my-3">
				<label for="bhit">조회수</label>
				<input type="number" class="form-control" value='<%=bhit %>' id="bhit" name="bhit" readonly />
			</div>
			<div class="my-3">
				<label for="bname">글쓴이</label>
				<input type="text" class="form-control" value='<%=bname %>' id="bname" name="bname" readonly />
			</div>
			<div class="my-3">
				<label for="btitle">제목</label>
				<input type="text" class="form-control" value='<%=btitle %>' id="btitle" name="btitle" readonly />
			</div>
			<div class="my-3">
				<label for="bcontent">내용</label>
				<textarea class="form-control" id="bcontent" name="bcontent" readonly><%=bcontent %></textarea>
			</div>
			<div class="my-3">
				<a href="edit.jsp?bno=<%=bno%>" class="btn btn-dark" title="글 수정하기">수정</a> 
				<a href="delete.jsp?bno=<%=bno%>" class="btn btn-dark" title="글 삭제하기">삭제</a>
				<a href="list.jsp" class="btn btn-dark" title="목록 보러가기">목록</a>
			</div>
		</form>
	</div>
	
	
<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>