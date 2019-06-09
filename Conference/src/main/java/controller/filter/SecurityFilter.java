package controller.filter;

import controller.manager.PathManager;
import controller.util.SecurityUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter( filterName = "securityFilter",urlPatterns = "/app/*")
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        SecurityUtil securityUtil = new SecurityUtil();

        if(securityUtil.isSecureRequest(request)) {
            System.out.println("all right");
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            System.out.println("filter");
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    public void destroy() {

    }
}
