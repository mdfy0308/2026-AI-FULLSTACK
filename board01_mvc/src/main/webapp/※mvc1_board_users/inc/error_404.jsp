<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<% response.setStatus(200); %>
<%@include file="./board_header.jsp"%>
<!-- header-->

	<div class="container card my-5">
		<h3 class="card-header">ERROR 404</h3>
		<p class="p-3">요청하신 페이지가 없습니다. 관리자에게 문의하세요.</p>
		<a href="javascript:history.go(-1)" class="btn btn-light" title="이전 페이지로">이전 페이지로</a>
	</div>



<!-- footer -->
<%@include file="./board_footer.jsp"%>