<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%

	//jsp012_insert.jsp
	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");
	
	// 2. 연결~구문
	int delOrder = Integer.parseInt(request.getParameter("delOrder"));
	
	try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = null; PreparedStatement pstmt = null;
    	String url = "jdbc:mysql://localhost:3306/mbasic";
  		String sql = "delete from milk_order where ono=?";
  		
  		conn = DriverManager.getConnection(url, "root", "1234");
  		pstmt = conn.prepareStatement(sql);
  		
  		pstmt.setInt(1, delOrder);
  		
  		int result = pstmt.executeUpdate();
  		if(result > 0){ out.println("<script>alert('주문 삭제 완료!'); location.href='jsp012_milks.jsp'; </script>"); }
  		else { out.println("<script>alert('삭제 실패. 관리자에게 문의하세요.'); location.href='jsp012_milks.jsp'; </script>"); }
  		
  	// 3. 끊기
		if( pstmt != null ) { pstmt.close(); }
		if( conn != null ) { conn.close(); }
    	
    } catch(Exception e){ e.printStackTrace(); }
	

%>