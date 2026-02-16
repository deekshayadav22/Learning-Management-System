package com.learnsphere.service;

import com.learnsphere.dao.EnrollmentDAO;
import com.learnsphere.model.Enrollment;

import java.util.Optional;

public class EnrollmentService {

    private final EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public int enroll(int courseId, int studentId) {
        return enrollmentDAO.enroll(courseId, studentId);
    }

    public boolean updateProgress(int enrollmentId, int progress) {
        return enrollmentDAO.updateProgress(enrollmentId, progress);
    }

    public Optional<Enrollment> findEnrollment(int studentId, int courseId) {
        return enrollmentDAO.findByStudentAndCourse(studentId, courseId);
    }
}
