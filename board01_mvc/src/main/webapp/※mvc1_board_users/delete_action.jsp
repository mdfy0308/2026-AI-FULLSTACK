<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	request.setCharacterEncoding("UTF-8");
	int bno = Integer.parseInt(request.getParameter("bno"));
	String bpass = request.getParameter("bpass");
		
	try {

		// 1. 연동
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String url = "jdbc:mysql://localhost:3306/mbasic";
		String sql = "select * from mvcboard1 where bno=" + bno;

		conn = DriverManager.getConnection(url, "root", "1234");
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		String del = "delete from mvcboard1 where bno=?";

		if (rset.next()) {
			if (rset.getString("bpass").equals(bpass)) {
				pstmt = conn.prepareStatement(del);
				pstmt.setInt(1, bno);
				
				int result = pstmt.executeUpdate();
				if(result > 0) {
					out.print("<script> alert('삭제 완료!'); location.href='list.jsp'; </script>");
				} else { out.print("<script> alert('삭제 실패. 관리자에게 문의하세요.'); location.href='list.jsp'; </script>"); }
			} else {
				out.print("<script> alert('비밀번호가 다릅니다.'); history.back(); </script>");
			}
		}
		
		// 연동 끊기
		if (rset != null) { rset.close(); } 
		if (pstmt != null) { pstmt.close(); } 
		if (conn != null) { conn.close(); }

	} catch (Exception e) { e.printStackTrace(); }
%>