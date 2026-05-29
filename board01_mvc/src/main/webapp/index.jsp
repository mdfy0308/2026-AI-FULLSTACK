<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<% 
		String email = (String) session.getAttribute("email");
		
		if(email == null){
			response.sendRedirect("LoginAction");
		} else { 
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}
%>