package model;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class falseUserDAO {
	private Connection conn=dbUtil.getConnection();
	public void addOne(falseUser fu) throws SQLException
	{
		Statement stmt=(Statement)conn.createStatement();
		String sql="insert into falseuser(fusituation,fureason,funum,fuid) values('0','²»Êµ',1,'"+fu.getFuid()+"');";
		stmt.execute(sql);
	}

}
