package Servlet;

import javax.servlet.http.*;
import javax.servlet.*;

import DBHelp.DBConnection;
import Model.User;

import java.sql.*;
import java.io.*;

public class LoginServlet extends HttpServlet{
	
    private static final long serialVersionUID = 1L;
	public LoginServlet() {
        super();
    }

	public void destroy() {
		super.destroy(); 
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		boolean flag = false;
		String username="";
		Connection conn;
		try {
			conn = DBConnection.connect();
			String sql = "select uid from user where uidentity='0' and uid=? and upassword=? ;";
			PreparedStatement ps=conn.prepareStatement(sql);
			username=request.getParameter("username");
			ps.setString(1, request.getParameter("username"));
			ps.setString(2, request.getParameter("password"));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				flag = true;
			}			
	conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}


		if (flag){
			request.getRequestDispatcher("/Main.jsp").forward(request, response);
			request.getSession().setAttribute("username", username);
		} 
		else {
			request.setAttribute("message", "µ«¬º ß∞‹!«Î÷ÿ–¬ ‰»Î");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		}
	}
	
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		doGet(request,response);
	}	
	
}
