package com.learnsphere.filter;

import com.learnsphere.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter("/courses/create")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        Object userObj = req.getSession(false) != null
                ? req.getSession(false).getAttribute("user")
                : null;

        if (userObj == null) {
            res.sendRedirect(req.getContextPath() + "/auth/login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}
