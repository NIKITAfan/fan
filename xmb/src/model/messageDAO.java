package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class messageDAO {
	private Connection conn=dbUtil.getConnection();
	public List<message> getMessage(String uid) throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql = " select * from message where muid2='"+uid+"' order by mtime desc";
		ResultSet rs=stmt.executeQuery(sql);
		List<message> messageList=new ArrayList<message>();
		while(rs.next())
		{
			message m1=new message();
			m1.setMid(rs.getInt("mid"));
			m1.setMsituation(rs.getString("msituation").charAt(0));
			m1.setMtext(rs.getString("mtext"));
			m1.setMtime(rs.getDate("mtime"));
			m1.setMuid1(rs.getString("muid1"));
			m1.setMuid2(rs.getString("muid2"));
			String uid1=rs.getString("muid1");
			
			String sql1="select uidentity from user where uid='"+uid1+"'";
			Statement stmt1=(Statement) conn.createStatement();
			ResultSet rs1=stmt1.executeQuery(sql1);
			String uidentity="";
			while(rs1.next())
			{
				uidentity=rs1.getString("uidentity");
			}
			String uname="";
			if(uidentity.charAt(0)=='1')
			{
				Statement stmt2=(Statement) conn.createStatement();
				String sql2="select tname from teacher where tid='"+uid1+"'";
				ResultSet rs2=stmt2.executeQuery(sql2);
				while(rs2.next())
				{
					uname=rs2.getString("tname");
				}
			}
			else
			{
				Statement stmt3=(Statement) conn.createStatement();
				String sql3="select sname from student where sid='"+uid1+"'";
				ResultSet rs3=stmt3.executeQuery(sql3);
				while(rs3.next())
				{
					uname=rs3.getString("sname");
				}
			}
			m1.setMuname(uname);
			messageList.add(m1);
		}
		return messageList;
	}
	public void addMessage(message m) throws SQLException
	{
		String sql = " insert into message(muid1,muid2,mtext,msituation,mtime) values(?,?,?,?,sysdate());";
		PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
		
		ptmt.setString(1,m.getMuid1());
		ptmt.setString(2,m.getMuid2());
		ptmt.setString(3,m.getMtext());
		ptmt.setString(4,String.valueOf(m.getMsituation()));
		ptmt.execute();
	}
}
