<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	// jsp015_session.2jsp
	
	session.setMaxInactiveInterval(10*60); // seconds 10분동안 세션유지
	session.setAttribute("username", "sally");
	session.setAttribute("userage", "11");
	response.sendRedirect("jsp015_session1.jsp");

%>