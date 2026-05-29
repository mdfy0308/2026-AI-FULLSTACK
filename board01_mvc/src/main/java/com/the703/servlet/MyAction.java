package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyAction
 */
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAction() { super(); }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		if (email == null) {
		    response.sendRedirect("login.jsp");
		    return;
		}
		
		String nickname = "", mobile = "", udate = "", bip = "";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "select * from users where email=?";
			
			conn = DriverManager.getConnection(url, "root", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email); 
			
			rset = pstmt.executeQuery();
			
			while(rset.next()){
				nickname = rset.getString("nickname");
				mobile = rset.getString("mobile");
				udate = rset.getString("udate");
				bip = rset.getString("bip");
			}
			
			request.setAttribute("nickname", nickname);
			request.setAttribute("email", email);
			request.setAttribute("mobile", mobile);
			request.setAttribute("udate", udate);
			request.setAttribute("bip", bip);
			
			// 3. 끊기
			if(rset  != null){ rset.close();  }
			if(pstmt != null){ pstmt.close(); }
			if(conn  != null){ conn.close();  }
			
			request.getRequestDispatcher("my_page.jsp").forward(request, response);
			
		} catch(Exception e){ e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}
}


/*

3. Mypage
> 마이페이지 - Get 
1) 처리서블릿   : MyAction
2) 로그인한정보로 서버에서 해당이메일의 정보가져오기
3) 처리후  mypage.jsp로 사용자 정보 넘겨주기


*/