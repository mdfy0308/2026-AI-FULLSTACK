<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%

	//jsp012_update.jsp
	// 1. utf-8 설정
	request.setCharacterEncoding("UTF-8");

	// 2. request.getParameter() 이용해서 데이터 받기
    String uname = request.getParameter("uname");
    int unum = Integer.parseInt(request.getParameter("unum"));
    int order = Integer.parseInt(request.getParameter("order"));
    
    // 3. 드라이버 연결 - 구문 처리
    
    try{
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection conn = null; PreparedStatement pstmt = null;
    	String url = "jdbc:mysql://localhost:3306/mbasic";
  		String sql = "update milk_order set oname=?, onum=? where ono=?";
  		
  		conn = DriverManager.getConnection(url, "root", "1234");
  		pstmt = conn.prepareStatement(sql);
  		
  		pstmt.setString(1, uname);
  		pstmt.setInt(2, unum);
  		pstmt.setInt(3, order);
  		
  		int result = pstmt.executeUpdate();
  		if(result > 0){ out.println("<script>alert('주문 변경 완료!'); location.href='jsp012_milks.jsp'; </script>"); }
  		else { out.println("<script>alert('변경 실패. 관리자에게 문의하세요.'); location.href='jsp012_milks.jsp'; </script>"); }
  		
  	// 4. 끊기
		if( pstmt != null ) { pstmt.close(); }
		if( conn != null ) { conn.close(); }
    	
    } catch(Exception e){ e.printStackTrace(); }
    
%>