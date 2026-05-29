<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="./inc/board_header.jsp"%>
<!-- header-->

<%
	if (email == null) {
	    response.sendRedirect("login.jsp");
	    return;
	}
%>


   <div class="container card my-5">
      <h3 class="card-header"></h3>
      
   </div>



<!-- footer -->
<%@include file="./inc/board_footer.jsp"%>
<!-- 

5. Users
>  사용자목록 확인
1) 처리서블릿  : Users
2) 사용자들의 목록을 확인  - users.jsp 로 전체사용자의 정보확인 

-->

