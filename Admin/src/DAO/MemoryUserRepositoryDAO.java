package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import java.util.ArrayList;
import java.util.List;

import DBHelp.DBConnection;
import Interface.UserRepository;
import Model.View_Student____;

//∑÷“≥ ˝æ›‘¥

public class MemoryUserRepositoryDAO implements UserRepository {
   

    @SuppressWarnings("null")
	@Override
    public List<View_Student____> listAll() {
    	Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<View_Student____> list = new ArrayList<View_Student____>();
       try {
           conn= DBConnection.connect();
           String sql=
        		   "select s.sid,s.sschool,s.sadvantage,s.sintroduction,s.sname,count(sp.sppid) as count  from student s LEFT JOIN "+
        		   "stu_project sp on sp.spsid=s.sid GROUP BY s.sid,s.sname,s.sschool,s.sadvantage,s.sintroduction;"
;   
           stmt=conn.prepareStatement(sql);
           rs=stmt.executeQuery();
			while (rs.next()) {
				View_Student____ view = new View_Student____();
				view.setPcount(rs.getInt("count"));
				view.setSid(rs.getString("sid"));
				view.setSname(rs.getString("sname"));
				if(rs.getString("sintroduction")!="")
				{
				view.setadv1(rs.getString("sintroduction"));
				}
				else
				{
					view.setadv1("Œ¥ÃÓ–¥");
				}
				view.setschool(rs.getString("sschool"));
				if(rs.getString("sadvantage")!="")
				{
				view.setadv(rs.getString("sadvantage"));
				}
				else
				{
					view.setadv("Œ¥ÃÓ–¥");
				}
				
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