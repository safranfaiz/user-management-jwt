package com.globle.surge.usermanagement.service.impl;

import com.globle.surge.usermanagement.model.User;
import com.globle.surge.usermanagement.repository.UserRepository;
import com.globle.surge.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User userRegistration(User user) {
        return userRepository.save(user);
    }

    @Override
    public User login(User user) {
        User userData = userRepository.findByEmail(user.getEmail());

        if(userData != null){
            return userData;
        }
        return null;
    }
}
