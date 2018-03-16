package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

import java.sql.SQLException;
import java.util.*;

public class createMessageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public createMessageServlet() {
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
			String uid1=request.getParameter("uid1");
			String uid2=request.getParameter("uid2");
			String uidentity=request.getParameter("uidentity");
			
			System.out.println("message:"+uid2);
			
			if(uidentity.charAt(0)=='2')
			{
				String order=request.getParameter("order");
				if(order=="0")
				{
				message m=new message();
				m.setMuid1(uid1);
				m.setMuid2(uid2);
				m.setMtext("邀请评价");
				m.setMsituation('0');
				try {
					new messageDAO().addMessage(m);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else
				{
					message m=new message();
					m.setMuid1(uid1);
					m.setMuid2(uid2);
					m.setMtext("申请项目");
					m.setMsituation('0');
					try {
						new messageDAO().addMessage(m);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			else
			{
				message m=new message();
				m.setMuid1(uid1);
				m.setMuid2(uid2);
				m.setMtext("邀请加入");
				m.setMsituation('0');
				try {
					new messageDAO().addMessage(m);
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
