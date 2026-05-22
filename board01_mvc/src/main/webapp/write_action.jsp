<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	
	// 2. request.getParameter() 이용해서 데이터 받기
	String bname = request.getParameter("bname");
	String bpass = request.getParameter("bpass");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	String bip = request.getParameter("bip");
	
	try {
		//드라이버 연동~구문
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "insert into mvcboard1(bname, bpass, btitle, bcontent, bip) values(?, ?, ?, ?, ?)";
	
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
	
		pstmt.setString(1, bname);
		pstmt.setString(2, bpass);
		pstmt.setString(3, btitle);
		pstmt.setString(4, bcontent);
		pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
	
		int result = pstmt.executeUpdate();
		if(result > 0) {
			out.print("<script> alert('등록 완료!'); location.href='list.jsp'; </script>");
		} else { out.print("<script> alert('등록 실패. 관리자에게 문의하세요.'); location.href='list.jsp'; </script>"); }
	
		// 끊기
		if (pstmt != null) { pstmt.close(); }
		if (conn != null) { conn.close(); }
	
	} catch (Exception e) {
		e.printStackTrace();
	}
%>