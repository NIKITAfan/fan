package Servlet;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MemoryUserRepositoryDAO;
import Model.View_Student____;
public class ListServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    private List<View_Student____> users;
    private MemoryUserRepositoryDAO repository =new MemoryUserRepositoryDAO();
   
	public ListServlet() {
        super();
    }

	public void destroy() {
		super.destroy(); 
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
		
			    users = repository.listAll();
				String p = request.getParameter("page");
	        int page;
	        try {
	            //当前页数
	            page = Integer.valueOf(p);
	        } catch (NumberFormatException e) {
	            page = 1;
	        }
	        //用户总数
	        int totalUsers = users.size();
	        //每页用户数
	        int usersPerPage = 10;
	        //总页数
	        int totalPages = totalUsers % usersPerPage == 0 ? totalUsers / usersPerPage : totalUsers / usersPerPage + 1;
	        //本页起始用户序号
	        int beginIndex = (page - 1) * usersPerPage;
	        //本页末尾用户序号的下一个
	        int endIndex = beginIndex + usersPerPage;
	        if (endIndex > totalUsers)
	            endIndex = totalUsers;
	        request.setAttribute("totalUsers", totalUsers);
	        request.setAttribute("usersPerPage", usersPerPage);
	        request.setAttribute("totalPages", totalPages);
	        request.setAttribute("beginIndex", beginIndex);
	        request.setAttribute("endIndex", endIndex);
	        request.setAttribute("page", page);
	        request.setAttribute("users", users);
	        request.getRequestDispatcher("/Third.jsp").forward(request,response);
				
		
         
	}
	
	
}
