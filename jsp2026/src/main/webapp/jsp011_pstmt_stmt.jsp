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
		<h3 class="card-header">PSTMT_STMT</h3>
		<pre class="alert alert-info">
	      	1. jdbc - Java database Connectivity
	      		- java 와 db를 연결해 sql을 실행해주는 표준 api
	      	2. mysql, oracle, mssql... 다양한 dbms와 연결
	      	3. 사용방법
	      		- https://dev.mysql.com/downloads/
	      		[src] - [main] - [webapp] - [WEB-INF] - [lib] - mysql-connector-j-8.4.0.jar 		
	      	4. JDBC
		      	1) Class.forName() 드라이버 로딩
		      	2) DriverManager Connection 활성화
		      	3) Connection DB 연동
		      	4) Statement, PreparedStatement sql 구문 실행
		      		PreparedStatement pstmt =  
						conn.prepareStatement("insert into userinfo (name, age) values(?,?)");
						
					pstmt.setString(1, "alpha"); //? 순서, 값
					pstmt.setInt(2, 11); //? 순서, 값
						
					int result = pstmt.executeUpdate(); // INSERT, UPDATE, DELETE,  실행한 줄수
					
					////////////////////////////////////////////////////////////
					
		      	5) jdbc 연동끊기
		</pre>
		<%	
			try{
				Class.forName("com.mysql.cj.jdbc.Driver"); //1. 드라이버 로딩
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mbasic", // url + DB명
						"root", 
						"1234"); //2. JDBC 연동
						
				////////////////////////////////////////////////////////////
				PreparedStatement pstmt =  
					conn.prepareStatement("insert into userinfo (name, age) values(?,?)");
				pstmt.setString(1, "alpha"); //? 순서, 값
				pstmt.setInt(2, 11); //? 순서, 값
						
				int result = pstmt.executeUpdate();
				if(result > 0){ out.println("insert 성공!"); }
				
				////////////////////////////////////////////////////////////
				if(pstmt != null) { pstmt.close(); }
				if(conn != null){ conn.close(); }
			} catch(Exception e) { e.printStackTrace(); }
		%>
		
		<%
			try{
				//1. 드라이버 로딩	
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/mbasic",
						"root",
						"1234");//2. JDBC 연동
						
				////////////////////////////////////////////////////////////
				PreparedStatement pstmt = null; ResultSet rset = null;
				pstmt = conn.prepareStatement("select * from userinfo");
				
				rset = pstmt.executeQuery(); 
				// 표 pstmt.executeQuery() - select 
				// pstmt.executeUpdate(); // INSERT, UPDATE, DELETE,  실행한 줄수		
				/* mysql> select * from userinfo;
                +----+--------+------+
                | no | name   | age  |
                +----+--------+------+
                |  1 | first  |   11 |
                |  2 | second |   22 |
                |  3 | third  |   33 |
                |  4 | fourth |   44 |
                +----+--------+------+ */
                
                while( rset.next() ) {
                	out.println("<p>" + rset.getInt("no") 	   + "/" 
               						  + rset.getString("name") + "/" 
                					  + rset.getInt("age")     + "</p>" );
                	// 칸 rset.getInt("필드명");
                }
				////////////////////////////////////////////////////////////
                if(rset  != null){ rset.close();  }
                if(pstmt != null){ pstmt.close(); }
				if(conn  != null){ conn.close();  } //3. 끊기
				
			} catch(Exception e){ e.printStackTrace();}
			
		%>
   </div>
</body>
</html>