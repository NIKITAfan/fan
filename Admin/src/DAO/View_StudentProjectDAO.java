package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.*;

import DBHelp.DBConnection;
public class View_StudentProjectDAO {
	
		public ArrayList<View_StudentProject> getView_StudentPtojects(String sid,ArrayList<View_StudentProject> list ){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
	       try {
	           conn= DBConnection.connect();
	           String sql=
	"select sc.scrank, p.pnum,p.pname,sr.srjob,sc.sccomment,sr.srreview  from (((stu_project sp INNER JOIN project p on sp.sppid=p.pid)"
	+        			"  left JOIN studentcomment sc on sc.pname=p.pname and sc.scsid=sp.spsid) left JOIN"
	 +       				  " studentreview sr on sr.srsid=sp.spsid and sr.srpname=p.pname)where sp.spsid=?;"
;   
	           stmt=conn.prepareStatement(sql);
	           stmt.setString(1,sid);
	           rs=stmt.executeQuery();
				while (rs.next()) {
					View_StudentProject view = new View_StudentProject();
					view.setPname(rs.getString("pname"));
					view.setsrjob(rs.getString("srjob"));
					view.setsccomment(rs.getString("sccomment"));
					view.setsrreview(rs.getString("srreview"));
					view.setpaiming(rs.getInt("scrank"));
					view.setsum(rs.getInt("pnum"));
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
