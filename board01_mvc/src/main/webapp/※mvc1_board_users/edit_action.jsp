<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	String bname = request.getParameter("bname");
	String bpass= request.getParameter("bpass");
	String btitle = request.getParameter("btitle");
	String bcontent = request.getParameter("bcontent");
	
	try {
		// 1. 드라이버 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from mvcboard1 where bno="+ bno;
		
		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		
		rset = pstmt.executeQuery();
		
		if( rset.next() ){
			// 2. 만약 비밀번호가 동일하면
			if(rset.getString("bpass").equals(bpass)){				
				// 값 세팅 
				String update = "update mvcboard1 set bname=?, bpass=?, btitle=?, bcontent=? where bno=?";
				
				pstmt = conn.prepareStatement(update);
				pstmt.setString(1, bname);
				pstmt.setString(2, bpass);
				pstmt.setString(3, btitle);
				pstmt.setString(4, bcontent);
				pstmt.setInt(5, bno);

				int result = pstmt.executeUpdate();
				if(result > 0) {
					out.print("<script> alert('수정 완료!'); location.href='list.jsp'; </script>");
				} else { out.print("<script> alert('수정 실패. 관리자에게 문의하세요.'); location.href='list.jsp'; </script>"); }
			} else {
				out.print("<script> alert('비밀번호가 다릅니다.'); history.back(); </script>");
			}
			
	       	// 끊기
	  		if(rset != null){ rset.close(); }
	       	if(pstmt != null){ pstmt.close(); }
	       	if(conn  != null){ conn.close(); }
		}
	} catch( Exception e ){ e.printStackTrace(); }

%>