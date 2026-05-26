<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 

	request.setCharacterEncoding("UTF-8");
	String nickname = request.getParameter("nickname");
	String bpass = request.getParameter("bpass");
	String email = request.getParameter("email");
	String mobile = request.getParameter("mobile");
	
	try{
		// 1. 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from users";
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		
		// 2-1. 중복 걸러야돼.. 이메일?
		while(rset.next()){
			if(email.equals(rset.getString("email"))){
				out.print("<script> alert('이미 등록된 이메일입니다.'); history.back(); </script>");
			} else { 
				// 2-2. users 테이블에 정보 넣고싶음
				String uduser = "insert into users(nickname, bpass, email, mobile, bip) values (?, ?, ?, ?, ?)";
				pstmt = conn.prepareStatement(uduser);
				pstmt.setString(1, nickname);
				pstmt.setString(2, bpass);
				pstmt.setString(3, email);
				pstmt.setString(4, mobile);
				pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
				
				int result = pstmt.executeUpdate();
				
				if(result > 0) { 
					out.print( "<script> alert('가입 완료!'); location.href='list.jsp'; </script>" );
				} else { out.print( "<script> alert('가입 실패. 관리자에게 문의하세요.'); history.back(); </script>" ); }
			}
		}
		
		
		// 3. 끊기
		if(rset != null){ rset.close(); }
		if(pstmt != null){ pstmt.close(); }
		if(conn != null){ conn.close(); }
		
	} catch(Exception e){
		e.printStackTrace();
	}
	
%>