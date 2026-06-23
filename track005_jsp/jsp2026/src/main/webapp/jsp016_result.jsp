<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");
	// 데이터 넘겨받기
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	String nickname = "";
	
	try {
		// sql 구문처리
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users where email=? and bpass=?";
		String user = "root";
		String pass = "1234";
	
		conn = DriverManager.getConnection(url, user, pass);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, bpass);
	
		rset = pstmt.executeQuery();
	
		if (rset.next()) {
			nickname = rset.getString("nickname");
			session.setAttribute("email", email);
			session.setAttribute("nickname", nickname);
			out.println("<script>alert('반갑습니다, " + nickname + "님!'); location.href='jsp016_login.jsp'; </script>");
	
		} else { out.println("<script> alert('로그인 실패'); history.go(-1); </script>"); }
	
		// 끊기
		if (rset != null) { rset.close(); } 
		if (pstmt != null) { pstmt.close(); } 
		if (conn != null) { conn.close(); }
	} catch (Exception e) { e.printStackTrace(); }
%>