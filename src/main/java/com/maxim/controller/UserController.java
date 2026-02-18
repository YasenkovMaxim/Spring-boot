package com.maxim.controller;

import com.maxim.model.Role;
import com.maxim.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        //Temp
        User user = new User();
        user.setAge(22);
        user.setId(id);
        user.setEmail("maxi@yandex.ru");
        user.setFirstName("Maxim");
        user.setLastName("Yasenkau");
        user.setCreated(Instant.now());
        user.setUpdated(Instant.now());
        return user;
    }
}
