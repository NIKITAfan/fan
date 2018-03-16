package DAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import Model.View_School;
public class View_guolvDAO{
	public ArrayList<View_School> getADV(ArrayList<View_School> list){
       try {
           ArrayList<Integer> num =new ArrayList<Integer>();
           int[] num2 =new int [list.size()];     //num重新排序
           ArrayList<Integer> num3 =new ArrayList<Integer>();  // 取最大10个 并去重
           ArrayList<Integer> num4 =new ArrayList<Integer>();  // 结果
           ArrayList<String> adv =new ArrayList<String>();
           ArrayList<String> adv2 =new ArrayList<String>();   //结果
    	   for(int i=0;i<list.size();i++)
    	   {
    		   adv.add(list.get(i).getschool());
    		   num.add(list.get(i).getnum());
    		   num2[i]=list.get(i).getnum();
    	   }
    	   Arrays.sort(num2);
    	   
    	   
    	   for(int i=num2.length-1;i>=num2.length-10;i--)
    	   {
    		   num3.add(num2[i]);
    	   }
    	   
    	   num3  = new ArrayList<Integer>(new HashSet<Integer>(num3));   //去重
    	   System.out.println("总数去重");
    	   for(int i=0;i<num3.size();i++)
    	   {
    		   System.out.print(num3.get(i)+"  ");
    	   }
    	   
    	   
    	   for(int i=0;i<num3.size();i++)
    	   {
    		   for(int j=0;j<num.size();j++)
    		   {
    			   if(num.get(j)==num3.get(i))
    			   {
    				   adv2.add(adv.get(j));
    				   num4.add(num.get(j));
    			   }
    		   }
    	   }
    	   ArrayList<View_School> list2 =new ArrayList<View_School>();
    	   for(int i=0;i<adv2.size();i++)
    	   {
    		   View_School view =new View_School();
    		   view.setnum(num4.get(i));
    		   view.setschool(adv2.get(i));
    		   list2.add(view);
    		   
    	   }
    	   System.out.println("list长"+list2.size());
    	   for(int i=0;i<list2.size();i++)
    	   {
    		   System.out.println("list内容");
    		   System.out.print(list2.get(i).getnum());
    		   System.out.print(list2.get(i).getschool());
    	   }
			return list2; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			
		}
	}
}
