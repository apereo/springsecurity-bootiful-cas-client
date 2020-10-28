package com.mycompany.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.mycompany.model.User;
import com.mycompany.service.UserService;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private static final List<User> USERS = new ArrayList<>();

    static {
        for (int i = 0; i < 20; i++) {
            USERS.add(new User().userId(UUID.randomUUID().toString()).userName("user_" + i));
        }
    }

    @Override
    public void add(final User user) {
        LOG.info("Insert a new user");
        USERS.add(user);
    }

    @Override
    public List<User> getAllUsers() {
        LOG.info("Get all new users");
        return USERS;
    }

    @Override
    public Optional<User> getUserById(final String userId) {
        return USERS.stream().filter(u -> userId.equalsIgnoreCase(u.getUserId())).findFirst();
    }

}
