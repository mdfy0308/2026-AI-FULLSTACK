<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@include file="../inc/header.jsp"  %>
<!-- 	header		 -->
<!-- 	header		 -->
	<script>
	window.addEventListener("load" , function(){
		let  result = '${result}';   // el
		console.log(result);
		
		if( result == "글쓰기 실패" || result == "비밀번호 확인" ){  
			alert(result);  history.go(-1);  
		}  // 알림창, 뒤로 가기
		else if(result.length != 0){  alert(result); }  
	}); 
	</script>

    <!--  content -->
    <section class="container my-5">
        <h3> MultiBoard </h3>
        <table class="table  table-striped table-bordered table-hover"
		style="font-size:14px; text-align:center;">
            <caption> BOARD 목록 </caption>
		<thead>
			<tr>
				<th scope="col">NO</th>
				<th scope="col">TITLE</th>
				<th scope="col">WRITER</th>
				<th scope="col">DATE</th>
				<th scope="col">HIT</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dto" items="${list}" varStatus="status">
				<tr> 
				<!-- 전체글갯수(listtotal) - [(페이지 수(0, 10, 20...) + forEach의 순서(0,1,2,3)]
				 	 100 - (2페이지(10) + 최상단의 글(index : 0)) = 90(게시글 번호) -->
					<td>${paging.listtotal - (paging.pstartno + status.index)}</td>
					<td><a href="${pageContext.request.contextPath}/board/detail.do?bno=${dto.bno}"
						 style="text-decoration:none; color:inherit;">
							${ dto.btitle } </a></td>
					<td>${ dto.bname  }</td>
					<td>${ dto.bdate  }</td>
					<td>${ dto.bhit   }</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot><tr><td colspan="5">
            	<ul class="pagination justify-content-center">
	            	<!-- 이전 -->
					<c:if test="${paging.start > 1}">
						<li class="page-item">
							<a href="?pstartno=1" class="page-link">처음</a></li>
						<li class="page-item">
							<a href="?pstartno=${paging.start - 1}" class="page-link">이전</a>
						</li>
					</c:if>
						
					<!-- 1 ~ 10 -->
	            	<c:forEach var="i" begin="${paging.start}" end="${paging.end}">
	            		<li class="page-item <c:if test="${i==paging.current}"> active </c:if> ">
	            			<a href="?pstartno=${i}" class="page-link">${i}</a>
	            		</li>
	            	</c:forEach>
	            	
	            	<!-- 다음 / 하단의 전체페이지 > end -->
	            	<c:if test="${paging.end < paging.pagetotal}">
	            		<li class="page-item"><a
							href="?pstartno=${paging.end + 1}" class="page-link">다음</a></li>
						<li class="page-item"><a
							href="?pstartno=${paging.pagetotal}" class="page-link">끝</a></li>
	            	</c:if>
	            	
            	</ul></td></tr>
            </tfoot>
        </table>

        <div  class="text-end">
           <a href="${pageContext.request.contextPath}/board/write.do"  
           	  title="글쓰기 폼"  class="btn btn-primary" >글쓰기</a>
        </div>
    </section>

 
<!-- 	footer		 -->
<!-- 	footer		 -->
<%@include file="../inc/footer.jsp"  %>