package com.sample.controller;


import com.sample.model.User;
import com.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    private User login(@RequestBody String email, String password) {
        return userService.getUserByEmailAndPassword(email, password);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    private String signup(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/users/{userid}")
    private User getUser(@PathVariable String userid) {
        return userService.getUser(userid);
    }

    @RequestMapping("/users/token/{token}")
    private User getUserByToken(@PathVariable String token) {
        return userService.getUserByToken(token);
    }


}