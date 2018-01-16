package controller;

import model.UserEntity;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = {"*.jsp","/deleteFilmServlet","/listProductServlet","/loadListFormServlet"}, servletNames = {}, dispatcherTypes = {DispatcherType.REQUEST})
public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//loadListFormServlet
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        System.out.println("entering filter...");

        String uri = request.getServletPath();
        String pageName = uri.substring(uri.lastIndexOf("/")+1);

        System.out.println("requested -- >" + pageName);
        HttpSession session = request.getSession(false);
        if(session != null) {

            Object user = session.getAttribute("user");
            UserEntity dtoUser = null;
            String stringUser = "";
            if(user instanceof UserEntity){
                dtoUser = (UserEntity) session.getAttribute("user");
            } else if(user instanceof String){
                stringUser = (String) session.getAttribute("user");
            }

            //UserEntity dtoUser = (UserEntity) session.getAttribute("user");

            if (!pageName.equals("loginServlet") && !pageName.equals("Login.jsp") && !pageName.equals("home.jsp")) {
                if ((dtoUser == null) && stringUser.equals("")) {
                    response.sendRedirect("Login.jsp"); return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("exiting filter...");
    }

    @Override
    public void destroy() {

    }
}
