package com.learnsphere.servlet;

import com.learnsphere.model.User;
import com.learnsphere.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/auth/*")
public class AuthServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if (path == null || "/login".equals(path)) {
            req.getRequestDispatcher("/auth/login.jsp").forward(req, resp);
            return;
        }

        if ("/register".equals(path)) {
            req.getRequestDispatcher("/auth/register.jsp").forward(req, resp);
            return;
        }

        if ("/logout".equals(path)) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();
        if (path == null) {
            path = "/login";
        }

        if ("/login".equals(path)) {
            handleLogin(req, resp);
            return;
        }

        if ("/register".equals(path)) {
            handleRegister(req, resp);
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    private void handleLogin(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<User> userOpt = userService.login(email, password);

        if (userOpt.isPresent()) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", userOpt.get());
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/login.jsp?error=1");
        }
    }

    private void handleRegister(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if (role == null || role.isBlank()) {
            role = "STUDENT";
        }

        Optional<User> userOpt = userService.register(name, email, password, role);

        if (userOpt.isPresent()) {
            HttpSession session = req.getSession(true);
            session.setAttribute("user", userOpt.get());
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendRedirect(req.getContextPath() + "/auth/register.jsp?error=1");
        }
    }
}
