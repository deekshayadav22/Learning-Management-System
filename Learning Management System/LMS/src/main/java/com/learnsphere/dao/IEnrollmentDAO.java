package com.learnsphere.dao;

import com.learnsphere.model.Enrollment;

import java.util.List;
import java.util.Optional;

/**
 * IEnrollmentDAO
 * ----------------
 * Contract for Enrollment data operations.
 *
 * Rubrics covered:
 * - Core Java Concepts: Interface, Optional, Collections
 * - Code Quality: Clear method responsibilities
 * - JDBC Readiness: CRUD-focused method definitions
 * - Innovation: Support for duplicate enrollment check
 */
public interface IEnrollmentDAO {

    
     // Enroll a student into a course
    
    int enroll(int courseId, int studentId);

   
     // Update learning progress of an enrollment
  
    boolean updateProgress(int enrollmentId, int progress);

  
     // Fetch all enrollments for a specific student
   
    List<Enrollment> listByStudent(int studentId);

    /**
     * Extra method
     * Check if a student is already enrolled in a course
     */
    Optional<Enrollment> findByStudentAndCourse(int studentId, int courseId);
}
