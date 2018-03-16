package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class studentDAO {
		private Connection conn=dbUtil.getConnection();
		public student getOne(String sid) throws SQLException
		{
			Statement stmt=(Statement)conn.createStatement();
			String sql = " select * from student where sid='"+sid+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()==false)
			{
				return null;
			}
			else
			{
				student stu=new student();
				stu.setSid(rs.getString("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setSadvantage(rs.getString("sadvantage"));
				stu.setSdepartment(rs.getString("sdepartment"));
				stu.setSgrade(rs.getString("sgrade"));
				stu.setSimage(rs.getString("simage"));
				stu.setSintroduction(rs.getString("sintroduction"));
				stu.setSmail(rs.getString("smail"));
				stu.setSmajor(rs.getString("smajor"));
				stu.setSpoint(rs.getInt("spoint"));
				stu.setSschool(rs.getString("sschool"));
				return stu;
			}
		}
	
		public List<student> getAll() throws SQLException
		{
			Statement stmt=(Statement)conn.createStatement();
			String sql = " select * from student";
			ResultSet rs=stmt.executeQuery(sql);
			List<student> studentList=new ArrayList<student>();
			while(rs.next())
			{
				student stu=new student();
				stu.setSid(rs.getString("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setSadvantage(rs.getString("sadvantage"));
				stu.setSdepartment(rs.getString("sdepartment"));
				stu.setSgrade(rs.getString("sgrade"));
				stu.setSimage(rs.getString("simage"));
				stu.setSintroduction(rs.getString("sintroduction"));
				stu.setSmail(rs.getString("smail"));
				stu.setSmajor(rs.getString("smajor"));
				stu.setSpoint(rs.getInt("spoint"));
				stu.setSschool(rs.getString("sschool"));
				studentList.add(stu);
			}
			return studentList;
		}
		
		public void updateOne(student s) throws SQLException
		{
			String sql = " update student set sname=?,smail=?,sschool=?,sintroduction=?,sadvantage=? where sid='"+s.getSid()+"';";
			PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
			ptmt.setString(1,s.getSname());
			ptmt.setString(2,s.getSmail());
			ptmt.setString(3,s.getSschool());
			ptmt.setString(4,s.getSintroduction());
			ptmt.setString(5,s.getSadvantage());
			ptmt.execute();
		}
}
