package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.util.*;

public class studentreviewDAO {
		Connection conn=dbUtil.getConnection();
		public void addOne(studentreview sr) throws SQLException
		{
			String sql=" insert into studentreview(srpname,srsid,srjob,srreview) values(?,?,?,?)";
			PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
			ptmt.setString(1,sr.getSrpname());
			ptmt.setString(2,sr.getSrsid());
			ptmt.setString(3,sr.getSrjob());
			ptmt.setString(4,sr.getSrreview());
			ptmt.execute();
		}
		
		public List<studentreview> findAll(String sid) throws SQLException
		{
			List<studentreview> srList=new ArrayList<studentreview>();

			Statement stmt=(Statement) conn.createStatement();
			String sql = " select * from studentreview where srsid='"+sid+"';";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				studentreview sr=new studentreview();
				sr.setSrjob(rs.getString("srjob"));
				sr.setSrpname(rs.getString("srpname"));
				sr.setSrreview(rs.getString("srreview"));
				sr.setSrsid(rs.getString("srsid"));
				srList.add(sr);
			}
			return srList;
		}
}
