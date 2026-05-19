<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
		<!-- Latest compiled and minified CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
		<!-- Latest compiled JavaScript -->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	
	<body>
		<header class="p-5 text-bg-success">
			<h1>MILK ORDER Project</h1>
			<p>PreparedStatement Ex</p>
		</header>

		<div class="container card mt-5 p-3">
	   		<h2 class="card-header text-bg-success">Milk Menu</h2>
	   		<table class="table mb-5">
	   			<caption>우유메뉴</caption>
	   			<thead class="table-light">
	   				<tr>
		   				<th scope="col">NO</th>
		   				<th scope="col">NAME</th>
		   				<th scope="col">PRICE</th>
	   				</tr>
	   			</thead>
	   			<tbody>
		   			<%
		   				try{
		   					Class.forName("com.mysql.cj.jdbc.Driver"); //1. 드라이버연동
		   	   				Connection conn = DriverManager.getConnection( //2. JDBC 연동
		   	   						"jdbc:mysql://localhost:3306/mbasic", 
		   	   						"root", 
		   	   						"1234");
		   	   				
		   					////////////////////////////////////////////////
		   	   				PreparedStatement pstmt = null;
		   					ResultSet rset = null;
		   					pstmt = conn.prepareStatement("select * from milk order by mprice asc");
		   					
		   					rset = pstmt.executeQuery(); 
		   					int i=1;
		   					while( rset.next() ){
		   						out.println(
		   								"<tr><td>" + (i++) + "</td>" +
		   								"<td>" + rset.getString("mname") + "</td>" +
		   								"<td>" + rset.getInt("mprice") + "</td></tr>"
		   								);
		   					}		   						
		   	   				////////////////////////////////////////////////
		   	   				//3. 연동 끊기
		   					if(rset  != null){ rset.close();  }
		   		               if(pstmt != null){ pstmt.close(); }
		   	   				if(conn != null){ conn.close(); }
		   				} catch(Exception e){ e.printStackTrace(); }
		   			%>
	   			</tbody>
	   		</table>
		</div>


		<div class="container card my-5 p-3 text-bg-dark">
			<h2 class="card-header">Milk Order</h2>
			<table class="table table-light mb-5">
				<caption>주문 현황</caption>
	   			<thead>
	   				<tr>
		   				<th scope="col">NO</th>
		   				<th scope="col">NAME</th>
		   				<th scope="col">PRICE</th>
		   				<th scope="col">주문날짜</th>
	   				</tr>
	   			</thead>
	   			<tbody>
	   				<%
	   					try{ // 1. 드라이버 연동
	   						Class.forName("com.mysql.cj.jdbc.Driver");
	   						Connection conn = null; 
	   						PreparedStatement pstmt = null;
	   						ResultSet rset = null;
	   						
	   						// 2. JDBC 연동
	   						conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mbasic", "root", "1234");
	   						pstmt = conn.prepareStatement("select * from milk_order order by ono asc");
	   						
	   						rset = pstmt.executeQuery();
	   						while(rset.next()){
	   							out.println(
		   								"<tr><td>" + rset.getInt("ono") + "</td>" +
		   								"<td>" + rset.getString("oname") + "</td>" +
		   								"<td>" + rset.getInt("oprice") + "</td>" +
		   								"<td>" + rset.getDate("odate") + "</td></tr>"
		   								);
		   					}		
	   					} catch(Exception e){ e.printStackTrace(); }
	   				%>
	   			</tbody>
	   		</table>
		</div>


		<div class="container card mt-5 p-3 text-bg-dark">
			<h2 class="card-header">Milk 주문하러가기</h2>	
			<div class="container">
				<h3 class="text-bg-success card-header">주문하기</h3>
				<form action="#" method="post" onsubmit="return check()">
					<div class="container card p-3">
						<label for="oderName" class="form-label" >주문할 우유 이름</label>
						<input type="text" class="form-control" placeholder="주문할 우유 이름을 적어주세요!!" 
						id="oderName"  name="oderName"/> <br>
						<label for="orderNum" class="form-label" >주문할 우유 갯수</label>
						<input type="number" class="form-control" placeholder="우유 갯수를 적어주세요!!"
						id="orderNum"  name="orderNum" />
					</div>
					<div class="container my-1"> 
						<button type="submit" class="btn btn-success" title="주문하기">주문하기</button>
					</div>
				</form>
			</div>
		</div>
		<script>
			function check(){
				let oderName = document.getElementById("oderName");
				let orderNum = document.getElementById("orderNum");
				
				if(oderName.value.trim()==""){
					alert("우유 이름을 적어주세요.");
					oderName.focus();
					return false;
				}
				if(orderNum.value.trim()==""){
					alert("우유 갯수를 적어주세요.");
					orderNum.focus();
					return false;
				}
				return true;
			}
		</script>
		
	</body>
</html>