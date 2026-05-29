<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%	
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	String nickname = "";
	
	boolean loginSuccess = false;
			
	try {
			// 1. 드라이버 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
	
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from users where email=? and bpass=?";
			conn = DriverManager.getConnection(url, "root", "1234");
			pstmt = conn.prepareStatement(sql);
	
			pstmt.setString(1, email);
			pstmt.setString(2, bpass);
	
			rset = pstmt.executeQuery();
	
			if (rset.next()) {
				nickname = rset.getString("nickname");
				session.setAttribute("email", email);
				session.setAttribute("nickname", nickname);
				loginSuccess = true;
			}
			
			// 3. 끊기
			if (rset != null) { rset.close(); } 
			if (pstmt != null) { pstmt.close(); } 
			if (conn != null) { conn.close(); }
			
		} catch (Exception e) { e.printStackTrace(); }
	
	if (loginSuccess) {
        out.print("<script>alert('로그인 성공!'); location.href='list.jsp';</script>");
    } else {
        out.print("<script>alert('이메일 또는 비밀번호가 일치하지 않습니다.'); history.back();</script>");
    }
	
%>