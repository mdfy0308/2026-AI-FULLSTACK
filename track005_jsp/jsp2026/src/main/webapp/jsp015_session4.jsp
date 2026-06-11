<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%
	// jsp015_session4.jsp
	
	session.invalidate();
	response.sendRedirect("jsp015_session1.jsp"); // 로그아웃시 - 모든 세션의 정보 지우기

%>