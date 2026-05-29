package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JoinAction")
public class JoinAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinAction() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String nickname = request.getParameter("nickname");
		String bpass = request.getParameter("bpass");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try{
			// 1. 드라이버 연동
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null; PreparedStatement pstmt = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "insert into users(nickname, bpass, email, mobile, bip) values (?, ?, ?, ?, ?)";
			
			conn = DriverManager.getConnection(url, "root", "1234");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickname);
			pstmt.setString(2, bpass);
			pstmt.setString(3, email);
			pstmt.setString(4, mobile);
			pstmt.setString(5, InetAddress.getLocalHost().getHostAddress());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) { 
				out.println("<script>  alert('회원가입에 성공했습니다.');  location.href='LoginAction';  </script>");
	         }else { out.println("<script>  alert('회원가입에 실패했습니다');   history.go(-1);  </script>"); }
		
			
			// 3. 끊기
			if(pstmt != null){ pstmt.close(); }
			if(conn != null){ conn.close(); }
			
		} catch(Exception e){ e.printStackTrace(); }
	}
}

/*

1.  Join
> 회원가입폼   - Get
> 회원가입처리 - Post
1) 처리서블릿   : JoinAction
2) 데이터 노출  : x
3) 보관데이터   : nickname , bpass , email , mobile
4) 처리경로     : 처리후 로그인 폼으로 (LoginAction - Get) 

*/