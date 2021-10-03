package com.globle.surge.usermanagement.controller;

import com.globle.surge.usermanagement.config.JwtTokenUtil;
import com.globle.surge.usermanagement.model.User;
import com.globle.surge.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    @Autowired
    UserService userService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/users")
    public User userRegistration(@RequestBody User user){

        if(user.getEmail() != null && user.getName() != null && user.getPassword() != null){
            return userService.userRegistration(user);
        }

        return null;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user){

        if(user.getEmail() != null && user.getPassword() != null){
            if(userService.login(user) != null) {
                return ResponseEntity.ok(jwtTokenUtil.generateToken(user));
            }
        }
        return ResponseEntity.ok("Not found");
    }

}
