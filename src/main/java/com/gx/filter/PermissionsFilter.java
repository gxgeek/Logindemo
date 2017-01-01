package com.gx.filter;

import com.gx.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by gx on 2016/12/26.
 */
public class PermissionsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest)request;
            HttpServletResponse httpServletResponse = (HttpServletResponse)response;
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("user");
            if (user!=null){
                chain.doFilter(request,response);
            }else {
                httpServletResponse.sendRedirect((httpServletRequest.getContextPath()+"/user/error"));
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
