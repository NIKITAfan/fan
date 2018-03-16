package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_FalseProject;

import DBHelp.DBConnection;
public class DoneView_FalseProjectDAO {
	
		public ArrayList<View_FalseProject> getView_FalseProjects(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_FalseProject> list = new ArrayList<View_FalseProject>(); 
	       try {
	           conn= DBConnection.connect();
	           String sql="select fp.fpid ,p.pname, t.tname, p.pintroduction as fpreason, count(fpid) as fpnum,"
	        		 +  "(case fp.fpsituation when '1' then '已处理' else '未处理' end) as fpsituation "
	        		  + "from  (falseproject fp INNER JOIN project p on fp.fpid=p.pid)"
	        		+  "INNER JOIN teacher t on t.tid=p.ptid  where  fp.fpsituation='1'"
	        		+  "group by fpid,pname,tname,pintroduction,fpsituation;";
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
				while (rs.next()) {
					View_FalseProject view = new View_FalseProject();
					view.setPid(rs.getInt("fpid"));
					view.setPname(rs.getString("pname"));
					view.setTname(rs.getString("tname"));
					view.setFpreason(rs.getString("fpreason"));
					view.setFpnum(rs.getInt("fpnum"));
					view.setFpsituation(rs.getString("fpsituation"));
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
