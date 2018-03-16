package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.SQLException;
import java.util.*;
import model.*;

public class updateZiliaoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public updateZiliaoServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String order=request.getParameter("order");
			String uid=request.getParameter("uid");
			String name=request.getParameter("name");
			name=new String(name.getBytes("ISO-8859-1"),"utf-8");
			
			String mail=request.getParameter("mail");
			mail=new String(mail.getBytes("ISO-8859-1"),"utf-8");
			
			String school=request.getParameter("school");
			school=new String(school.getBytes("ISO-8859-1"),"utf-8");
			
			String introduction=request.getParameter("introduction");
			introduction=new String(introduction.getBytes("ISO-8859-1"),"utf-8");
			
			if(order.charAt(0)=='1')
			{
				teacher t=new teacher();
				t.setTname(name);
				t.setTmail(mail);
				t.setTschool(school);
				t.setTintroduction(introduction);
				t.setTid(uid);
				try {
					new teacherDAO().updateOne(t);
					System.out.println("update teacher:"+uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				String advantage=request.getParameter("advantage");
				advantage=new String(advantage.getBytes("ISO-8859-1"),"utf-8");
				student s=new student();
				s.setSname(name);
				s.setSmail(mail);
				s.setSschool(school);
				s.setSintroduction(introduction);
				s.setSid(uid);
				s.setSadvantage(advantage);
				try {
					new studentDAO().updateOne(s);
					System.out.println("update student:"+uid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			 
			
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
