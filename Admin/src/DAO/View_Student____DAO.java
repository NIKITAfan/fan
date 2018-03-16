package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_Student____;

import DBHelp.DBConnection;
public class View_Student____DAO {
	
		public ArrayList<View_Student____> getView_Students(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_Student____> list = new ArrayList<View_Student____>(); 
	       try {
	           conn= DBConnection.connect();
	           String sql=
	        		   "select s.sid,s.sname,count(sp.sppid) as count  from student s LEFT JOIN "+
	        		   "stu_project sp on sp.spsid=s.sid GROUP BY s.sid,s.sname;"
;   
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
				while (rs.next()) {
					View_Student____ view = new View_Student____();
					view.setPcount(rs.getInt("count"));
					view.setSid(rs.getString("sid"));
					view.setSname(rs.getString("sname"));
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
