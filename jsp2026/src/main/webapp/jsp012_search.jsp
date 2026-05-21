<%@page import="java.sql.*"%>
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
		<h3 class="card-header">메뉴 검색</h3>
      	
      	<table class="table">
      		<caption> 검색 결과 </caption>
      		<thead>
      			<tr>
      				<th scope="col">메뉴 번호</th>
      				<th scope="col">메뉴 이름</th>
      				<th scope="col">메뉴 가격</th>
      			</tr>
      		</thead>
      		<tbody>
      			<% 
				//1. 데이터 넘겨받기
				request.setCharacterEncoding("UTF-8");
				int snum = Integer.parseInt(request.getParameter("snum"));	
				
				try{
					//2. 드라이버 연동-처리-끊기
					PreparedStatement pstmt = null; Connection conn = null;
					ResultSet rset = null;
					String url = "jdbc:mysql://localhost:3306/mbasic";
					String sql = "select * from milk where mno="+ snum ;
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(url, "root", "1234");
					
					pstmt = conn.prepareStatement(sql);
					rset = pstmt.executeQuery();
					// pstmt.setInt(1, snum);
					
					if(rset.next()){
						out.print(
								"<tr><td>"+ rset.getInt("mno")  + "</td>" +
								"<td>" + rset.getString("mname") + "</td>" + 
								"<td>" + rset.getInt("mprice") + "</td></tr>"
						);
					} else {
						out.print(
								"<tr><td> 해당 메뉴 없음 </td><td> - </td><td>-</td></tr>");
					}
					
					// 3. 연동 끊기
					if(rset  != null){ rset.close();  }
					if(pstmt != null){ pstmt.close(); }
					if(conn  != null){ conn.close();  }
					
				} catch(Exception e){ e.printStackTrace(); }
				%>
      		</tbody>
      	</table>
		<p><a href="javascript:history.go(-1)" class="btn btn-success">이전 페이지로</a></p>
	
   </div>
</body>
</html>
