package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class studentcommentDAO {
	private Connection conn=dbUtil.getConnection();
	public List<studentcomment> getComments(String sid) throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql = " select * from studentcomment where scsid='"+sid+"';";
		ResultSet rs=stmt.executeQuery(sql);
		List<studentcomment> scList=new ArrayList<studentcomment>();
		while(rs.next())
		{
			studentcomment sc=new studentcomment();
			sc.setPname(rs.getString("pname"));
			sc.setSccomment(rs.getString("sccomment"));
			sc.setScprojectstar(rs.getInt("scprojectstar"));
			sc.setScrank(rs.getInt("scrank"));
			sc.setScsid(rs.getString("scsid"));
			sc.setScstar(rs.getInt("scstar"));
			sc.setSctag(rs.getString("sctag"));
			scList.add(sc);
		}
		return scList;
	}
	
	public void addComment(studentcomment sc) throws SQLException
	{
		String sql = " insert into studentcomment(scsid,scrank,scstar,sctag,sccomment,pname,scprojectstar) values(?,?,?,?,?,?,?);";
		PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
		ptmt.setString(1,sc.getScsid());
		ptmt.setInt(2,sc.getScrank());
		ptmt.setInt(3,sc.getScstar());
		ptmt.setString(4,sc.getSctag());
		ptmt.setString(5,sc.getSccomment());
		ptmt.setString(6,sc.getPname());
		ptmt.setInt(7,sc.getScprojectstar());
		ptmt.execute();
	}
}
