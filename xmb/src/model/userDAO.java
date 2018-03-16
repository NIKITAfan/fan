package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class userDAO {
	private Connection conn=dbUtil.getConnection();
	private String sql;
	public user getOne(String uid,String upassword) throws SQLException
	{
		Statement stmt=(Statement)conn.createStatement();
		sql = "select * from user where uid='"+uid+"' and upassword='"+upassword+"'";
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()==false)
		{
			return null;
		}
		else
		{
			user u1=new user();
			u1.setUid(rs.getString("uid"));
			u1.setUpassword(rs.getString("upassword"));
			u1.setUidentity(rs.getString("uidentity").charAt(0));
			u1.setUcondition(rs.getString("ucondition").charAt(0));
			return u1;
		}
	}
}
