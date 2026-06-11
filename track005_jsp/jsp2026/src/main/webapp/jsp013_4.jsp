<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%

	int age = Integer.parseInt(request.getParameter("age"));

	if (age < 20){ response.sendRedirect("jsp013_child.jsp?age=" + age); // 쿼리스트링
	} else { request.getRequestDispatcher("jsp013_adult.jsp").forward(request, response); }

%>