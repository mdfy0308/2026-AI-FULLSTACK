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
   	  <% String query = request.getParameter("query"); %>
      <h3 class="card-header"> 검색어</h3>
      <p> 검색 결과 : <%=query%> </p>
      
      <p><a href="javascript:history.go(-1)" class="btn btn-success">이전 페이지로</a></p>
     
   </div>
</body>
</html>