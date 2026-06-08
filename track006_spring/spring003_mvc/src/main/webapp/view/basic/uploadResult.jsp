<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../inc/header.jsp"%>
<!-- 	header		 -->
<!-- 	header		 -->



<div class="container my-3 p-3">
	<h3> 업로드 결과 </h3>
	<div class="my-3 p-3">
		<label for="name" class="form-label">작성자</label>
		<input type="text" id="name" name="name" class="form-control" value="${name}" readonly >
	</div>
	<div class="my-3 p-3">
		<label for="file" class="form-label">파일</label>
		<img style="max-width: 100%;" src="${pageContext.request.contextPath}/upload/${file}" alt="업로드한 이미지" />
	</div>
	
</div>


<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"%>