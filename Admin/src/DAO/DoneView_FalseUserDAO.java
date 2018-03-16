package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_FalseUser;

import DBHelp.DBConnection;
public class DoneView_FalseUserDAO {
	
		public ArrayList<View_FalseUser> getView_FalseUsers(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_FalseUser> list = new ArrayList<View_FalseUser>(); 
	       try {
	           conn= DBConnection.connect();
	           String sql=
	        		   "select uid,name,(case uidentity when 1 then '老师' else '学生' end) as uidentity,"
	              		+ "fureason,count(uid) as funum,(case fusituation when 1 then '已处理' else '未处理' end) as fusituation "
	              		+ "from (user inner join falseuser on uid=fuid "
	              		+ "inner join (select tid as id,tname as name from teacher "
	              		+ "union select sid as id,sname as name from student)new_talbe on uid=id) where fusituation='1'"
	              		+ "group by uid,name,uidentity,fureason,fusituation     ;";
;   
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
				while (rs.next()) {
					View_FalseUser view = new View_FalseUser();
					view.setFuid(rs.getString("uid"));
					view.setName(rs.getString("name"));
					view.setUidentity(rs.getString("uidentity"));
					view.setFunum(Integer.parseInt(rs.getString("funum")));
					view.setFureason(rs.getString("fureason"));
					view.setFusituation(rs.getString("fusituation"));
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
