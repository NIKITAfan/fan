package model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class falseProjectDAO {
	private Connection conn=dbUtil.getConnection();
	public void addOne(falseProject fp) throws SQLException
	{
		Statement stmt=(Statement)conn.createStatement();
		String sql="insert into falseproject(fpsituation,fpid) values('0','"+fp.getFpid()+"');";
		stmt.execute(sql);
	}

}
