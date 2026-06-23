<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<div class="container card my-5">
   		<h3 class="card-header">request-getParameterValues</h3>
		<% 
		String username = request.getParameter("username");
		String[] options = request.getParameterValues("option1");
		%>
		
		<%=username%>
      	<%=Arrays.toString( options )%>
      	<br/>
      	<br/>
      	<p><a href="javascript:history.go(-1)" class="btn btn-primary">이전 페이지로</a></p>
	</div>
</body>
</html>