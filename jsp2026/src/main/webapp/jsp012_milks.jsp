<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<header class="p-5 text-bg-success">
		<h1>MILK ORDER Project</h1>
		<p>PreparedStatement Ex</p>
	</header>

	<div class="container card mt-5 p-3">
		<h3 class="card-header text-bg-success">Milk Menu</h3>
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
				try {
					Class.forName("com.mysql.cj.jdbc.Driver"); //1. 드라이버연동
					Connection conn = DriverManager.getConnection( //2. JDBC 연동
					"jdbc:mysql://localhost:3306/mbasic", "root", "1234");

					///////////////////////////////////////////////
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					pstmt = conn.prepareStatement("select * from milk order by mprice asc");

					rset = pstmt.executeQuery();
					int i = 1;
					while (rset.next()) {
						out.println("<tr><td>" + (i++) + "</td>" + 
						"<td>" + rset.getString("mname") + "</td>" + 
						"<td>"+ rset.getInt("mprice") + "</td></tr>");
					}
					///////////////////////////////////////////////
					//3. 연동 끊기
					if (rset != null) { rset.close(); }
					if (pstmt != null) { pstmt.close(); }
					if (conn != null) { conn.close(); }
				} catch (Exception e) { e.printStackTrace(); }
				%>
			</tbody>
		</table>
	</div>


	<div class="container card my-5 p-3 text-bg-dark">
		<h3 class="card-header">Milk Order</h3>
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
				try { // 1. 드라이버 연동
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rset = null;

					// 2. JDBC 연동
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
					pstmt = conn.prepareStatement("select * from milk_order order by ono asc");
					rset = pstmt.executeQuery(); // 표(select)
					
					while (rset.next()) {
						out.println("<tr><td>" + rset.getInt("ono") + 
								"</td>" + "<td>" + rset.getString("oname") + 
								"</td>" + "<td>" + rset.getInt("onum") + 
								"</td>" + "<td>" + rset.getString("odate") + "</td></tr>");
					}
					//3. 연동 끊기
					if (rset != null ) { rset.close();  }
					if (pstmt != null) { pstmt.close(); }
					if (conn != null ) { conn.close();  }
				} catch (Exception e) { e.printStackTrace(); }
				%>
			</tbody>
		</table>
	</div>


	<div class="container card mt-5 p-3 text-bg-dark">
		<h3 class="card-header">Milk 주문, 수정, 삭제</h3>
		<div id="accordion">
			<div class="card">
				<div class="card-header text-white bg-success">
					<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
						주문하기 </a>
				</div>
				<div id="collapseOne" class="collapse show"
					data-bs-parent="#accordion">
					<div class="card-body">
						<form action="jsp012_insert.jsp" method="post"
							onsubmit="return check()">
							<div class="my-3">
								<label for="oname" class="form-label">주문할 우유 이름</label> <input
									type="text" class="form-control"
									placeholder="주문할 우유 이름을 적어주세요." id="oname" name="oname" /> <br>
							</div>
							<div class="my-3">
								<label for="onum" class="form-label">주문할 우유 갯수</label> <input
									type="number" class="form-control" placeholder="우유 갯수를 적어주세요."
									id="onum" name="onum" />
							</div>
							<div class="my-3">
								<button type="submit" class="btn btn-success" title="주문하기">주문하기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!--  -->
			<!--  -->
			<!--  -->
			<div class="card">
				<div class="card-header text-white bg-success">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseTwo"> 주문 수정 </a>
				</div>
				<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						<form action="jsp012_update.jsp" method="post"
							onsubmit="return updateCheck()">
							<div class="my-3">
								<label for="order" class="form-label">수정할 주문 번호</label> <input
									type="number" class="form-control" placeholder="주문번호를 입력하세요."
									id="order" name="order" />
							</div>
							<div class="my-3">
								<label for="uname" class="form-label">수정할 우유 이름</label> <input
									type="text" class="form-control"
									placeholder="변경할 메뉴 이름을 입력하세요." id="uname" name="uname" />
							</div>
							<div class="my-3">
								<label for="unum" class="form-label">수정할 우유 갯수</label> <input
									type="number" class="form-control" placeholder="변경할 갯수를 입력하세요."
									id="unum" name="unum" />
							</div>
							<div class="my-3">
								<button type="submit" class="btn btn-success" title="주문 수정하기">수정하기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!--  -->
			<!--  -->
			<!--  -->
			<div class="card">
				<div class="card-header text-white bg-success">
					<a class="collapsed btn" data-bs-toggle="collapse"
						href="#collapseThree"> 주문 삭제 </a>
				</div>
				<div id="collapseThree" class="collapse" data-bs-parent="#accordion">
					<div class="card-body">
						<form action="jsp012_delete.jsp" method="post"
							onsubmit="return delCheck()">
							<div class="my-3">
								<label for="delOrder" class="form-label">삭제할 주문 번호</label> <input
									type="number" class="form-control" placeholder="주문번호를 입력하세요."
									id="delOrder" name="delOrder" />
							</div>
							<div class="my-3">
								<button type="submit" class="btn btn-success" title="주문 삭제하기">삭제하기</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--  -->
	<!--  -->
	<!--  -->
	<script>
		function check() {
			let oderName = document.getElementById("oname");
			let orderNum = document.getElementById("onum");
			
			if (oderName.value.trim() == "") {
				alert("우유 이름을 적어주세요.");
				oderName.focus();
				return false;
			}
			if (orderNum.value.trim() == "") {
				alert("우유 갯수를 적어주세요.");
				orderNum.focus();
				return false;
			}
			return true;
		}
		
		function updateCheck(){
			let upName = document.getElementById("uname");
			let upNum = document.getElementById("unum");
			
			if (upName.value.trim() == "") {
				alert("변경할 이름을 적어주세요.");
				upName.focus();
				return false;
			}
			if (upNum.value.trim() == "") {
				alert("변경할 갯수를 적어주세요.");
				upNum.focus();
				return false;
			}
			return true;
		}
		
		function delCheck(){
			let delOrder = document.getElementById("delOrder");
			
			if (delOrder.value.trim() == "") {
				alert("삭제할 주문번호를 적어주세요.");
				delOrder.focus();
				return false;
			}
			return true;
			
		}
	</script>

</body>
</html>