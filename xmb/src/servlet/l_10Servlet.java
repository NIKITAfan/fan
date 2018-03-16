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
public class l_10Servlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public l_10Servlet() {
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
			String scsid=request.getParameter("scsid");
	        String scrank=request.getParameter("scrank");
	        String sctag=request.getParameter("sctag");
	        sctag=new String(sctag.getBytes("ISO-8859-1"),"utf-8");
	        
	        String sccomment=request.getParameter("sccomment");
	        sccomment=new String(sccomment.getBytes("ISO-8859-1"),"utf-8");
	        
	        String pname=request.getParameter("pname");
	        pname=new String(pname.getBytes("ISO-8859-1"),"utf-8");
	        
	        studentcomment sc=new studentcomment();
	        sc.setPname(pname);
	        sc.setScsid(scsid);
	        sc.setSctag(sctag);
	        sc.setSccomment(sccomment);
	        sc.setScrank(Integer.valueOf(scrank));
	        try {
				new studentcommentDAO().addComment(sc);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
