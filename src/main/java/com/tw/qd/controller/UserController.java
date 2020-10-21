package com.tw.qd.controller;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/educations")
    public List<Education> getEducationsByUserId(@PathVariable Long id){
        return userService.getEducationsByUserId(id);
    }

}
