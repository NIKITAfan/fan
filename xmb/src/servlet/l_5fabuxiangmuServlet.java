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

public class l_5fabuxiangmuServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public l_5fabuxiangmuServlet() {
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

		 doPost(request,response);
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
		String pname=request.getParameter("pname");
		pname=new String(pname.getBytes("ISO-8859-1"),"UTF-8");
		
		String pelse=request.getParameter("pelse");
		pelse=new String(pelse.getBytes("ISO-8859-1"),"UTF-8");
		
		String pintroduction=request.getParameter("pintroduction");
		pintroduction=new String(pintroduction.getBytes("ISO-8859-1"),"UTF-8");
		
		String pnum=request.getParameter("pnum");
		String prequire=request.getParameter("prequire");
		prequire=new String(prequire.getBytes("ISO-8859-1"),"UTF-8");
		
		String ptid=request.getParameter("tid");
		project p=new project();
		p.setPname(pname);
		p.setPelse(pelse);
		p.setPnum(Integer.valueOf(pnum));
		p.setPintroduction(pintroduction);
		p.setPrequire(prequire);
		p.setPtid(ptid);
		try {
			new projectDAO().addOne(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("fabuxiangmu:"+pname);
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
