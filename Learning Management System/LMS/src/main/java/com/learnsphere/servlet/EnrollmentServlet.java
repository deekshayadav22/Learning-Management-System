package com.learnsphere.servlet;

import com.learnsphere.model.User;
import com.learnsphere.service.EnrollmentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/enroll")
public class EnrollmentServlet extends HttpServlet {

    private final EnrollmentService enrollmentService = new EnrollmentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/auth/login.jsp");
            return;
        }

        String courseIdStr = req.getParameter("courseId");
        if (courseIdStr == null) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int courseId;
        try {
            courseId = Integer.parseInt(courseIdStr);
        } catch (NumberFormatException e) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        User user = (User) session.getAttribute("user");

        // prevent duplicate enrollment (innovation / extra effort)
        if (enrollmentService.findEnrollment(user.getId(), courseId).isPresent()) {
            resp.sendRedirect(req.getContextPath() + "/courses/view?id=" + courseId + "&enrolled=1");
            return;
        }

        enrollmentService.enroll(courseId, user.getId());
        resp.sendRedirect(req.getContextPath() + "/courses/view?id=" + courseId);
    }
}
