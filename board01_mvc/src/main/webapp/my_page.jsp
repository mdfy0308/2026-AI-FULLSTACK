<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<%
	
	String email = (String) session.getAttribute("email");
	String nickname = "", mobile = "", udate = "", bip = "";
	
	if (email == null) {
	    response.sendRedirect("login.jsp");
	    return;
	}
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where email=?";
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email); 
		
		rset = pstmt.executeQuery();
		
		while(rset.next()){
			nickname = rset.getString("nickname");
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
		<h3>마이 페이지</h3>
		<table class="table table-striped table-hover">
			<caption>유저 상세정보</caption>
			<thead>
				<tr>
					<th scope="col">구분</th>
					<th scope="col">내용</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">닉네임</th>
					<td><%=nickname %></td>
				</tr>
				<tr>
					<th scope="row">이메일</th>
					<td><%=email%></td>
				</tr>
				<tr>
					<th scope="row">휴대폰</th>
					<td><%=mobile%></td>
				</tr>
				<tr>
					<th scope="row">가입일</th>
					<td><%=udate %></td>
				</tr>
				<tr>
					<th scope="row">가입IP</th>
					<td><%=bip %></td>
				</tr>
			</tbody>
		</table>
	</section>


<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>