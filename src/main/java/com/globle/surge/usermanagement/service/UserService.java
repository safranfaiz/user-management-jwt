package com.globle.surge.usermanagement.service;

import com.globle.surge.usermanagement.model.User;

public interface UserService {
    public User userRegistration(User user);
    public User login(User user);
}
