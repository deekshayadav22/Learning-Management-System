package com.learnsphere.dao;

import com.learnsphere.model.User;

import java.util.Optional;

/**
 * IUserDAO
 * Defines user-related database operations
 */
public interface IUserDAO {

    Optional<User> findByEmail(String email);

    Optional<User> getById(int id);

    int create(User user);

    boolean update(User user);

    boolean delete(int id);
}
