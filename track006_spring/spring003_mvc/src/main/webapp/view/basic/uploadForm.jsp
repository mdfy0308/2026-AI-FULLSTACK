<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
	
	
	<form action="${pageContext.request.contextPath}/upload" 
		  method="post" enctype="multipart/form-data">
		<div class="my-3 p-3">
			<label for="name">작성자</label>
			<input type="text" id="name" name="name" class="form-control" />
		</div>
		<div class="my-3 p-3">
			<label for="file">업로드할 파일</label>
			<input type="file" id="file" name="file" class="form-control" />
		</div>
		<div class="my-3 p-3 text-end">
			<input type="submit" class="btn-btn-success" value="업로드" />
		</div>
	</form>
	
	
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>
