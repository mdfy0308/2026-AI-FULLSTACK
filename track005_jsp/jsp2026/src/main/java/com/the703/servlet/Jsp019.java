package com.the703.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Jsp019
 */
@WebServlet("/MilkInsert")
public class Jsp019 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Jsp019() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 데이터 넘겨받기
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8"); //##
		
		String oname = request.getParameter("oname");
		int onum = Integer.parseInt(request.getParameter("onum"));
		
		// 2. sql 처리
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
			String url = "jdbc:mysql://localhost:3306/mbasic";
			String sql = "insert into milk_order(oname, onum, oip) values (?, ?, ?)";
			conn = DriverManager.getConnection(url, "root", "1234");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, oname);
			pstmt.setInt(2, onum);
			pstmt.setString(3, "192.168.40.5");
			
			int result = pstmt.executeUpdate();
			if(result != 0) { 
				System.out.println("주문 진행");
			} else { System.out.println("주문 재확인"); response.sendRedirect("jsp019_milk.jsp"); }
			
			// 3. 처리 결과 + 경로
			
			if(pstmt != null) { pstmt.close(); }
			if(conn != null) { conn.close(); }
			
		} catch(Exception e) { e.printStackTrace(); }
			
		response.sendRedirect("jsp019_index.jsp?oname=" + oname);
	} //do Post

}
