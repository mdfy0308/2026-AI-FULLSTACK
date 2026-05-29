<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<% response.setStatus(200); %>
<%@include file="./board_header.jsp"%>
<!-- header-->

	<div class="container card my-5">
		<h3 class="card-header">ERROR 500</h3>
		<a href="/list.jsp" class="btn btn-light" title="게시판으로">게시판으로</a>
	</div>
	<%=exception.getMessage() %>

<!-- footer -->
<%@include file="./board_footer.jsp"%>