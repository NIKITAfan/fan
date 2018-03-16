package DAO;
import java.sql.*;
import java.util.ArrayList;

import Model.View_FalseProject;
import Model.View_Project;
import DBHelp.DBConnection;
public class View_ProjectDAO{
	private String id;
	public View_ProjectDAO(String id){
		this.id=id;
	}
	public ArrayList<View_Project> getView_Projects(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<View_Project> list = new ArrayList<View_Project>(); 
       try {
           conn= DBConnection.connect();
           String sql="select pid,pname,tname,pdatefrom,pdateto,pnum,prequire,pintroduction,pelse,"
           		+ "(case pcondition when 1 then '正在招收' else '结束招收' end) as pcondition "
           		+ "from project inner join teacher where ptid=tid and pid=?;";      
           stmt=conn.prepareStatement(sql);
           stmt.setString(1, id);
           rs=stmt.executeQuery();
			while (rs.next()) {
				View_Project view = new View_Project();
				view.setPid(rs.getInt("pid"));
				view.setPname(rs.getString("pname"));
				view.setPtname(rs.getString("tname"));
				view.setPdatefrom(rs.getDate("pdatefrom"));
				view.setPdateto(rs.getDate("pdateto"));
				view.setPnum(rs.getInt("pnum"));
				view.setPrequire(rs.getString("prequire"));
				view.setPintroduction(rs.getString("pintroduction"));
				view.setPelse(rs.getString("pelse"));
				view.setPcondition(rs.getString("pcondition"));
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
