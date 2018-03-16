package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.View_Student;
import DBHelp.DBConnection;
public class View_StudentDAO{
	public ArrayList<View_Student> getView_Students(String sid,ArrayList<View_Student> list){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
       try {
           conn= DBConnection.connect();
           String sql="select sid,sname,spoint,smail,sschool,sdepartment,smajor,sgrade,sadvantage,sintroduction "
           		+ "from student where sid=?;";      
           stmt=conn.prepareStatement(sql);
           stmt.setString(1, sid);
           rs=stmt.executeQuery();
			while (rs.next()) {
				View_Student view = new View_Student();
				view.setuid(rs.getString("sid"));
				view.setadv(rs.getString("sadvantage"));
				view.setdep(rs.getString("sdepartment"));
				view.setemail(rs.getString("smail"));
				view.setgrade(rs.getString("sgrade"));
				view.setmajor(rs.getString("smajor"));
				view.setname(rs.getString("sname"));
				view.setPintrod(rs.getString("sintroduction"));
				view.setpoint(rs.getInt("spoint"));
				view.setschool(rs.getString("sschool"));
				list.add(view);
			}	conn.close();
			return list; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
					stmt = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
