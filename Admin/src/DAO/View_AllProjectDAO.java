package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_AllProject;

import DBHelp.DBConnection;
public class View_AllProjectDAO {
	
		public ArrayList<View_AllProject> getView_Projects(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_AllProject> list = new ArrayList<View_AllProject>(); 
	       try {
	           conn= DBConnection.connect();
	           String sql=
	        		  " select count(pid) as pnum from project ;";
	          String sql1= " select count(spsid) as snum from stu_project ;";
	       String sql2= " select count(sspid) as ssnum from  studentselfproject ;"
;   
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
	           View_AllProject view = new View_AllProject();
				while(rs.next())
				{view.setpnum(rs.getInt("pnum"));
				}
				stmt=conn.prepareStatement(sql1);
		        rs=stmt.executeQuery();
		        while(rs.next())
				{view.setsnum(rs.getInt("snum"));
				}
				stmt=conn.prepareStatement(sql2);
		        rs=stmt.executeQuery();
		        while(rs.next())
				{view.setssnum(rs.getInt("ssnum"));
				}
				list.add(view);
				conn.close();
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
