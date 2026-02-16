package com.learnsphere.service;

import com.learnsphere.dao.CourseDAO;
import com.learnsphere.model.Course;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private final CourseDAO courseDAO = new CourseDAO();

    public List<Course> listAll() {
        return courseDAO.listAll();
    }

    public Optional<Course> getById(int id) {
        return courseDAO.getById(id);
    }

    public List<Course> search(String keyword) {
        return courseDAO.searchByTitle(keyword);
    }

    public int create(Course course) {
        return courseDAO.create(course);
    }

    public boolean update(Course course) {
        return courseDAO.update(course);
    }

    public boolean delete(int id) {
        return courseDAO.delete(id);
    }
}
