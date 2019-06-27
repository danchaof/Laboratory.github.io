package ay.laboratory.filter;

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


public class LoginFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        // TODO Auto-generated method stub
        System.out.println("我是拦截器");
         HttpServletRequest servletRequest = (HttpServletRequest) arg0;  
         HttpServletResponse servletResponse = (HttpServletResponse) arg1;  
         HttpSession session = servletRequest.getSession();  
         String path = servletRequest.getServletPath(); 

         if(path.equals("/login.jsp")||path.equals("/login")){
                arg2.doFilter(arg0,arg1);            
                System.out.println("通过1");
         }
         else{
             String id = (String) session.getAttribute("id");
             if(id == null)
             {
                 System.out.println("拦截");
                 arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
             }else {
                    arg2.doFilter(arg0,arg1);            
            }
         }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}