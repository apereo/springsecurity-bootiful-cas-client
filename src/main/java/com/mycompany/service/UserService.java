package com.mycompany.service;

import java.util.List;
import com.mycompany.model.User;
import java.util.Optional;

public interface UserService {

    void add(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(String id);
}
