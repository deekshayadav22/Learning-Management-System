package com.learnsphere.service;

import com.learnsphere.dao.UserDAO;
import com.learnsphere.model.User;
import com.learnsphere.util.PasswordUtil;

import java.util.Optional;

public class UserService {

    private final UserDAO userDAO = new UserDAO();

    public Optional<User> register(String name, String email, String password, String role) {

        if (userDAO.findByEmail(email).isPresent()) {
            return Optional.empty();
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(PasswordUtil.hash(password));
        user.setRole(role);

        int id = userDAO.create(user);
        user.setId(id);

        return Optional.of(user);
    }

    public Optional<User> login(String email, String password) {

        Optional<User> userOpt = userDAO.findByEmail(email);
        if (userOpt.isEmpty()) {
            return Optional.empty();
        }

        User user = userOpt.get();
        String hashedPassword = PasswordUtil.hash(password);

        if (hashedPassword.equals(user.getPasswordHash())) {
            return Optional.of(user);
        }

        return Optional.empty();
    }
}
