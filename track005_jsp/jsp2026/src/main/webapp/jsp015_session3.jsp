<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	// jsp015_session3.jsp
	
	session.removeAttribute("userage");
	//response.sendRedirect("jsp015_session1.jsp"); // alert x
	out.println("<script> location.href = 'jsp015_session1.jsp'; </script>"); // alert o
	
%>