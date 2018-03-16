package Servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBHelp.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.http.*;
public class FalseProjectServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
	
    private String action ; 
	public FalseProjectServlet() {
        super();
    }

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		if(request.getParameter("del")!=null)
		{
			action = request.getParameter("del");
			System.out.println(action);
			if(action.equals("查封项目")) 
			{
				try {
					Connection con = DBConnection.connect();
					String sql="update falseproject set fpsituation = '1' where fpid=?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, pid);
					ps.execute();					
					
					String sql1="update project set pcondition = '0' where pid=?;";
					PreparedStatement ps1 = con.prepareStatement(sql1);
					ps1.setInt(1, pid);
					ps1.execute();			
					
					String sql11="select ptid from project where pid=?";
					PreparedStatement ps11 = con.prepareStatement(sql11);
					ResultSet rs = null;
					ps11.setInt(1, pid);
					rs=ps11.executeQuery();
				    String ptid=null;
					while(rs.next())
					{ptid=rs.getString("ptid");}
					
					String sql2="insert into message(muid1,muid2,mtext,msituation,mtime)"
							+"values(?,?,?,?,sysdate())"
							;
					PreparedStatement ps2 = con.prepareStatement(sql2);
					ps2.setString(1, "00000000001");
					ps2.setString(2, ptid);
					ps2.setString(3,"您有项目因举报已经被封禁");
					ps2.setInt(4, 7);
					ps2.execute();	
					con.close();
					request.getRequestDispatcher("/Main.jsp").forward(request, response);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}							
			}
			else if(action.equals("忽略举报")) 
			{
				try {
					Connection con = DBConnection.connect();
					String sql="update falseproject set fpsituation = '1' where fpid=?;";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setInt(1, pid);
					ps.execute();	
					con.close();
					request.getRequestDispatcher("/Main.jsp").forward(request, response);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}															
			}
			}else
			{
				System.out.println("错误");
			}
         }

}
