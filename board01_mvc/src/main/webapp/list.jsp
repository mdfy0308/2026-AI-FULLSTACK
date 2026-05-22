<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->


<section class="container my-5">
	<h3>MultiBoard</h3>
	<table class="table table-striped table-hover">
		<caption>BOARD LIST</caption>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">TITLE</th>
				<th scope="col">WRITER</th>
				<th scope="col">DATE</th>
				<th scope="col">HIT</th>
			</tr>
		</thead>
		<tbody>
			<%
			request.setCharacterEncoding("UTF-8");
			try {
				// 드라이버 연동~구문
				Class.forName("com.mysql.cj.jdbc.Driver");

				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				String url = "jdbc:mysql://localhost:3306/mbasic";
				String sql = "select * from mvcboard1 order by bno desc";

				conn = DriverManager.getConnection(url, "root", "1234");
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();
				
				while (rset.next()) {
					int bno = rset.getInt("bno");
					out.print("<tr><td>" + bno + "</td>"
					+ "<td><a style='text-decoration:none; color: inherit;' href='detail.jsp?bno=" + bno + "' title='상세보기'>"
					+ rset.getString("btitle") + "</a></td>" + "<td>" + rset.getString("bname") + "</td>" + "<td>"
					+ rset.getTimestamp("bdate") + "</td>" + "<td>" + rset.getInt("bhit") + "</td></tr>");
				}

				// 끊기
				if (rset != null) { rset.close(); } 
				if (pstmt != null) { pstmt.close(); } 
				if (conn != null) { conn.close(); }

			} catch (Exception e) { e.printStackTrace(); }
			%>
		</tbody>
	</table>
	<div class="text-end">
		
		<a href="write.jsp" title="글 작성하기" class="btn btn-light">글쓰기</a>
	</div>
</section>


<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>