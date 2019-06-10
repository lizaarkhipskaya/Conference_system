package controller.filter;

import controller.manager.PathManager;
import controller.util.SecurityUtil;
import model.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter( filterName = "securityFilter",urlPatterns = "/app/*")
public class SecurityFilter implements Filter {
    private static final Logger LOGGER = LogManager.getLogger(SecurityFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        SecurityUtil securityUtil = new SecurityUtil();

        if(securityUtil.isSecureRequest(request)) {
            filterChain.doFilter(servletRequest, servletResponse);
        }else {
            User user = (User)request.getSession().getAttribute("user");
            LOGGER.warn("User "+(user!=null ? user.toString() : "GUEST")+"tried to get access to not supported for him command");
            response.sendRedirect(request.getContextPath() + "/");
        }
    }

    @Override
    public void destroy() {

    }
}
