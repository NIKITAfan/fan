package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class student_projectDAO {
	Connection conn=dbUtil.getConnection();
	public List<project> getStudentProjects(String sid) throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql = " select p.* from project p,stu_project s where s.sppid=p.pid and s.spsid='"+sid+"'";
		ResultSet rs=stmt.executeQuery(sql);
		List<project> projectList=new ArrayList<project>();
		while(rs.next())
		{
			project p1=new project();
			p1.setPid(rs.getInt("pid"));
			p1.setPtid(rs.getString("ptid"));
			p1.setPname(rs.getString("pname"));
			p1.setPnum(rs.getInt("pnum"));
			p1.setPdatefrom(rs.getDate("pdatefrom"));
			p1.setPdateto(rs.getDate("pdateto"));
			p1.setPcondition(rs.getString("pcondition").charAt(0));
			p1.setPrequire(rs.getString("prequire"));
			p1.setPintroduction(rs.getString("pintroduction"));
			p1.setPelse(rs.getString("pelse"));
			projectList.add(p1);
		}
		return projectList;
	}
}