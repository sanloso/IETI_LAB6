package com.eci.taskplanner.components.service;

import com.eci.taskplanner.components.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getByName(String name);

    User create(User user);

    User update(User user);

    void remove(String name);
}
