package com.learnsphere.servlet;

import com.learnsphere.model.Course;
import com.learnsphere.model.User;
import com.learnsphere.service.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/courses/*")
public class CourseServlet extends HttpServlet {

    private final CourseService courseService = new CourseService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if (path == null || "/".equals(path)) {
            handleList(req, resp);
            return;
        }

        if ("/view".equals(path)) {
            handleView(req, resp);
            return;
        }

        if ("/create".equals(path)) {
            req.getRequestDispatcher("/courses/create.jsp").forward(req, resp);
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String path = req.getPathInfo();

        if ("/create".equals(path)) {
            handleCreate(req, resp);
            return;
        }

        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    private void handleList(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String q = req.getParameter("q");
        List<Course> courses;

        if (q != null && !q.trim().isEmpty()) {
            courses = courseService.search(q.trim());
        } else {
            courses = courseService.listAll();
        }

        req.setAttribute("courses", courses);
        req.getRequestDispatcher("/courses/list.jsp").forward(req, resp);
    }

    private void handleView(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String idStr = req.getParameter("id");
        if (idStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Optional<Course> courseOpt = courseService.getById(id);
        if (courseOpt.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        req.setAttribute("course", courseOpt.get());
        req.getRequestDispatcher("/courses/detail.jsp").forward(req, resp);
    }

    private void handleCreate(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");

        String title = req.getParameter("title");
        String description = req.getParameter("description");

        double price;
        try {
            price = Double.parseDouble(req.getParameter("price"));
        } catch (Exception e) {
            price = 0.0;
        }

        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setPrice(price);
        course.setInstructorId(user.getId());

        courseService.create(course);

        resp.sendRedirect(req.getContextPath() + "/courses");
    }
}
