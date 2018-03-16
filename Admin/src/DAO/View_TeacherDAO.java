package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.View_Teacher;
import DBHelp.DBConnection;
public class View_TeacherDAO{
	public ArrayList<View_Teacher> getView_Teachers(String tid,ArrayList<View_Teacher> list){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
       try {
           conn= DBConnection.connect();
           String sql="select tid,tname,tpoint,tmail,tschool,tdepartment,tintroduction "
              		+ "from teacher where tid=?;";      
              stmt=conn.prepareStatement(sql);
              stmt.setString(1, tid);
              rs=stmt.executeQuery();
   			while (rs.next()) {
   				View_Teacher view = new View_Teacher();
   				view.setuid(rs.getString("tid"));
   				
   				view.setdep(rs.getString("tdepartment"));
   				view.setemail(rs.getString("tmail"));
   				view.setname(rs.getString("tname"));
   				view.setPintrod(rs.getString("tintroduction"));
   				view.setpoint(rs.getInt("tpoint"));
   				view.setschool(rs.getString("tschool"));
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
