package com.learnsphere.dao;

import com.learnsphere.model.Course;

import java.util.List;
import java.util.Optional;

/**
 * ICourseDAO
 * Defines course-related database operations
 */
public interface ICourseDAO {

    List<Course> listAll();

    Optional<Course> getById(int id);

    List<Course> searchByTitle(String keyword);

    int create(Course course);

    boolean update(Course course);

    boolean delete(int id);
}
