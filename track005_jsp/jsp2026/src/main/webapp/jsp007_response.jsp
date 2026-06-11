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
		<h3 class="card-header">REQUEST-요청</h3>
		<pre class="alert alert-info">
	     	1. 처리 컨테이너 : jsp007_result.jsp
	     	2. 처리방식	 : get (주소표시창 줄 노출)
	     	3. 보관용기	 : para
		</pre>
     	
     	<form action="jsp007_result.jsp" method="get" onsubmit="return check()">
     		<div class="my-3">
     			<label for="para" class="form-label"> SEARCH </label>
     			<input type="search" class="form-contral" id="para" name="para"/>
     		</div>
     		<div class="my-3 text-end">
     			<button type="submit" class="btn btn-primary">전송</button>
     		</div>
     	</form>
	</div>
	<script>
		function check(){
			let para = document.getElementById("para");
			
			if(para.value.trim() == ""){
				alert("검색어를 입력하세요.");
				  para.focus();
				  return false;
			} return true;
		}
	</script>
   
</body>
</html>

