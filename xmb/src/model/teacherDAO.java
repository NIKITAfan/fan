package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class teacherDAO {
	private Connection conn=dbUtil.getConnection();
	
	public teacher getOne(String tid) throws SQLException
	{
		Statement stmt=(Statement)conn.createStatement();
		String sql = "select * from teacher where tid='"+tid+"'";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()==false)
		{
			return null;
		}
		else
		{
			teacher t=new teacher();
			t.setTname(rs.getString("tname"));
			t.setTid(rs.getString("tid"));
			t.setTmail(rs.getString("tmail"));
			t.setTpoint(rs.getInt("tpoint"));
			t.setTdepartment(rs.getString("tdepartment"));
			t.setTimage(rs.getString("timage"));
			t.setTintroduction(rs.getString("tintroduction"));
			t.setTschool(rs.getString("tschool"));
			return t;
		}
	}
	
	public void updateOne(teacher t) throws SQLException
	{
		String sql = " update teacher set tname=?,tmail=?,tschool=?,tintroduction=? where tid='"+t.getTid()+"';";
		PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
		ptmt.setString(1,t.getTname());
		ptmt.setString(2,t.getTmail());
		ptmt.setString(3,t.getTschool());
		ptmt.setString(4,t.getTintroduction());
		ptmt.execute();
	}
}
 
