package DAO;
import java.sql.*;
import java.util.ArrayList;
import Model.View_Student;
import DBHelp.DBConnection;

public class View_DateDAO{
	public ArrayList<Integer> getView_Dates(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> list=new ArrayList<Integer>();
       try {
    	  
           conn= DBConnection.connect();
           String sql="select d.dnNum from datenumber d where  d.dnDate=CURDATE();";      
           stmt=conn.prepareStatement(sql);
           rs=stmt.executeQuery();
			while (rs.next()) {
				int view;
				view=rs.getInt("dnNum");
				list.add(view);
			}
			 String sql2="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 1 day);";      
	           stmt=conn.prepareStatement(sql2);
	           rs=stmt.executeQuery();
				while (rs.next()) {
					int view;
					view=rs.getInt("dnNum");
					list.add(view);
				}
				 String sql3="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 2 day);";      
		           stmt=conn.prepareStatement(sql3);
		           rs=stmt.executeQuery();
					while (rs.next()) {
						int view;
						view=rs.getInt("dnNum");
						list.add(view);
					}
					 String sql4="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 3 day);";      
			           stmt=conn.prepareStatement(sql4);
			           rs=stmt.executeQuery();
						while (rs.next()) {
							int view;
							view=rs.getInt("dnNum");
							list.add(view);
						}
						 String sql5="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 4 day);";      
				           stmt=conn.prepareStatement(sql5);
				           rs=stmt.executeQuery();
							while (rs.next()) {
								int view;
								view=rs.getInt("dnNum");
								list.add(view);
							}
							 String sql6="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 5 day);";      
					           stmt=conn.prepareStatement(sql6);
					           rs=stmt.executeQuery();
								while (rs.next()) {
									int view;
									view=rs.getInt("dnNum");
									list.add(view);
								}
								 String sql7="select d.dnNum from datenumber d where  d.dnDate=date_sub(CURDATE(), interval 6 day);";      
						           stmt=conn.prepareStatement(sql7);
						           rs=stmt.executeQuery();
									while (rs.next()) {
										int view;
										view=rs.getInt("dnNum");
										list.add(view);
									}
			
			
			
			
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
