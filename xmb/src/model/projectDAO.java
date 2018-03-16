package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class projectDAO {
	Connection conn=dbUtil.getConnection();
	public List<project> getTeacherProjects(String tid) throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql = " select * from project where pcondition='1' and ptid='"+tid+"'";
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
	
	public List<project> getAll() throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql = " select * from project where pcondition='1' ";
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
	
	public void addOne(project p) throws SQLException
	{
		String sql = " insert into project(pname,ptid,pnum,prequire,pintroduction,pelse,pcondition)" +
				" values(?,?,?,?,?,?,?)";
		PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
		ptmt.setString(1,p.getPname());
		ptmt.setString(2,p.getPtid());
		ptmt.setInt(3,p.getPnum());
		ptmt.setString(4,p.getPrequire());
		ptmt.setString(5,p.getPintroduction());
		ptmt.setString(6,p.getPelse());
		ptmt.setString(7,"1");
		ptmt.execute();
	}
	
	public void changeOne(project p) throws SQLException
	{
		String sql = " update project set pname=?,pnum=?,prequire=?,pintroduction=?,pelse=? where pid="+p.getPid()+";";
		PreparedStatement ptmt=(PreparedStatement)conn.prepareStatement(sql);
		ptmt.setString(1,p.getPname());
		ptmt.setInt(2,p.getPnum());
		ptmt.setString(3,p.getPrequire());
		ptmt.setString(4,p.getPintroduction());
		ptmt.setString(5,p.getPelse());
		ptmt.execute();
	}
	
	public void deleteOne(String pid) throws SQLException
	{
		Statement stmt=(Statement) conn.createStatement();
		String sql=" update project set pcondition='0' where pid="+pid+";";
		stmt.execute(sql);
	}
 }

