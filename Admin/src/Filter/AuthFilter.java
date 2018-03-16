package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter implements Filter {

    /**
     * 销毁
     */
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //获取根目录所对应的绝对路径
        String currentURL = request.getRequestURI();
        HttpSession session = request.getSession(false);
        if(!currentURL.contains("login.jsp")&&!currentURL.contains("LoginServlet")){
            //判断当前页面是否是重顶次昂后的登陆页面页面，如果是就不做session的判断，防止死循环
            if(session==null||session.getAttribute("username")==null){ 
                response.sendRedirect(request.getContextPath()+"/login.jsp?filter=false");
                return;
            }
        }

        //继续向下执行
        chain.doFilter(request, response);
    }

    /**
     * 初始化
     */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}