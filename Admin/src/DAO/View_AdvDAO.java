package DAO;

import java.sql.*;
import java.util.ArrayList;
import Model.View_School;

import DBHelp.DBConnection;
public class View_AdvDAO {
	
		public ArrayList<View_School> getView_Advs(){
			Connection conn = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;
			ArrayList<View_School> list = new ArrayList<View_School>(); 
			ArrayList<String> list2=new ArrayList<String>();
			String list3=null;
			ArrayList<String> list4=new ArrayList<String>();
			ArrayList<Integer> list5=new ArrayList<Integer>();
	       try {
	           conn= DBConnection.connect();
	           String sql=" select sadvantage from student;";
	           stmt=conn.prepareStatement(sql);
	           rs=stmt.executeQuery();
				while(rs.next())
				{
					String view = null;
					view=rs.getString("sadvantage");
					list2.add(view);
				}
				
				list3=list2.get(0);
				for(int i=1;i<list2.size();i++)  //将所有的特长以逗号为界限存在一个String 里面
				{
					list3+=","+list2.get(i);
				}
				System.out.println(list3);
				
				
				
				int j=0;
				for(int i=0;i<list3.length();i++)  //分割特长
				{
					if(i==list3.length()-1)
					{
						String adv=null;
					    int num=j;
						for(;j<i+1;j++)
						{
							if(j==num&&((list3.charAt(j)!=',')&&(list3.charAt(j)!='，')))
							{
								adv=String.valueOf(list3.charAt(j));
							}
							else if(j==list3.length()-1&&((list3.charAt(j)!=',')||(list3.charAt(j)!='，')))
							{
								adv=null;
							}
							else
							{
							adv+=list3.charAt(j);}
						}
						System.out.println("adv    "+adv);
						if(list4.size()==0)
						{
							list4.add(adv);
						
						}
						else{
							for(int p=0;p<list4.size();p++){
								if(list4.get(p)!=null)
								{
									
								
								if(list4.get(p).equals(adv))
								{
									//list5.set(p, list5.get(p)+1);
									//System.out.println("个数"+list5.get(p));
								    break;
								}
								else 
								{
									if(p==list4.size()-1)
									{
										list4.add(adv);
										
										break;
									}
								}
								}
							}
						}
						j=i+1;
						
					}
					
					if(list3.charAt(i)==','||list3.charAt(i)=='，')
					{   String adv=null;
					    int num=j;
						for(;j<i;j++)
						{
							if(j==num)
							{
								adv=String.valueOf(list3.charAt(j));
							}
							else
							{
							adv+=list3.charAt(j);}
						}
						System.out.println("adv    "+adv);
						
						if(list4.size()==0&&adv!=null)
						{
							list4.add(adv);
							
						}
						
						else{
							
							for(int p=0;p<list4.size();p++){
								
								
								if(list4.get(p)!=null){
								if(list4.get(p).equals(adv))
								{
								    break;
								}
								else 
								{
									if(p==list4.size()-1)
									{
										list4.add(adv);
									
										break;
									}
								}
								}
							}
						}
						j=i+1;
						
					}
				}
				
				for(int p=0;p<list4.size();p++)
				{  
					if(list4.get(p)!=null){
			       int sum=0;
					int i=0;
					int j1=0;
					while(j1<list3.length())
					{ 
				    
					if(list4.get(p).charAt(i)==list3.charAt(j1))
					{
						i++;
						j1++;
						if(i==list4.get(p).length())
						{
							i=0;
							sum++;
						}
					}
					else
					{
						i=0;
						j1++;
					}
					}
				  list5.add(sum);
				}}
				
				ArrayList<String> list41=new ArrayList<String>();
				for(int i=0;i<list4.size();i++)
				{
					if(list4.get(i)!=null)
					{
						list41.add(list4.get(i));
					}
				}
				
				for(int i=0;i<list41.size();i++)
				{
					View_School v1=new View_School();
					v1.setnum(list5.get(i));
					v1.setschool(list41.get(i));
					list.add(v1);
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
