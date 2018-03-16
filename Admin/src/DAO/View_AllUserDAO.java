package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_AllUser;

import DBHelp.DBConnection;
public class View_AllUserDAO {
	
		public ArrayList<View_AllUser> getView_Users(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_AllUser> list = new ArrayList<View_AllUser>(); 
	       try {
	           conn= DBConnection.connect();
	           String sql=
	        		  " select count(uid) as unum from user where uidentity<>'0';";
	          String sql1= " select count(sid) as snum from student ;";
	       String sql2= " select count(tid) as tnum from  teacher ;"
;   
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           View_AllUser view = new View_AllUser();
				while(rs.next())
				{view.setunum(rs.getInt("unum"));
				}
				stmt=conn.prepareStatement(sql1);
		        rs=stmt.executeQuery();
		        while(rs.next())
				{view.setsnum(rs.getInt("snum"));
				}
				stmt=conn.prepareStatement(sql2);
		        rs=stmt.executeQuery();
		        while(rs.next())
				{view.settnum(rs.getInt("tnum"));
				}
		    	conn.close();
				list.add(view);
				
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
