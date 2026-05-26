<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String email = request.getParameter("email");
	String bpass = request.getParameter("bpass");
	
	try{
		// 1. 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String url="jdbc:mysql://localhost:3306/mbasic";
		String sql="select * from users";
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		
		// 2. 이메일/번호 값 받아서 비교하기
		while(rset.next()){
			if(rset.getString("email").equals(email) && rset.getString("bpass").equals(bpass)){
				out.print("<script> alert('로그인 성공!'); location.href='list.jsp'; </script>");
				session.setAttribute("email", email);
				break;
			}
		}
				
				
		// 3. 끊기
		if(rset  != null){ rset.close();  }
		if(pstmt != null){ pstmt.close(); }
		if(conn  != null){ conn.close();  }
		
		
	} catch(Exception e){ e.printStackTrace(); }


%>