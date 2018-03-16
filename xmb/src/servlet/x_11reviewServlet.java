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

public class x_11reviewServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public x_11reviewServlet() {
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

		 String sid=request.getParameter("sid");
		 String srjob=request.getParameter("srjob");
		 srjob=new String(srjob.getBytes("ISO-8859-1"),"UTF-8");
		 
		 String srreview=request.getParameter("srreview");
		 srreview=new String(srreview.getBytes("ISO-8859-1"),"UTF-8");
		 
		 String srpname=request.getParameter("srpname");
		 srpname=new String(srpname.getBytes("ISO-8859-1"),"UTF-8");
		 
		 studentreview sr=new studentreview();
		 sr.setSrjob(srjob);
		 sr.setSrpname(srpname);
		 sr.setSrreview(srreview);
		 sr.setSrsid(sid);
		 try {
			new studentreviewDAO().addOne(sr);
			System.out.println("add studentreview:"+sr.getSrpname());
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
