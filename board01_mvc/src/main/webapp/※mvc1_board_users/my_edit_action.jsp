<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	// 변수
	String email = (String) session.getAttribute("email");
	String nickname = request.getParameter("nickname");
	String mobile = request.getParameter("mobile");
	String bpass = request.getParameter("bpass");
	
	try{
		// 1. 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "update from users set nickname=?, mobile=? where email=? and bpass=?";
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
				
		pstmt.setString(1, nickname); 
		pstmt.setString(2, mobile); 
		pstmt.setString(3, bpass); 
		pstmt.setString(4, email); 
		
		int result = pstmt.executeUpdate();
		
		if(result > 0){
			out.print("<script>alert('수정 완료!') location.href='my_page.jsp'; <script>");
		} else { out.print("<script>alert('수정 실패.') history.go(-1); <script>"); }
				
		// 3. 끊기
		if(pstmt != null){ pstmt.close(); }
		if(conn  != null){ conn.close();  }
		
	} catch(Exception e){ e.printStackTrace();}
	



%>