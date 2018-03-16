package DBHelp;

import java.sql.*;

public class DBConnection {

	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://112.74.176.171:3306/xmb?useUnicode=true&characterEncoding=UTF-8";
	private static String user="root";
	private static String password="891223";
	
	public static Connection connect() throws Exception{
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url, user, password);
		return conn;
	}
}
