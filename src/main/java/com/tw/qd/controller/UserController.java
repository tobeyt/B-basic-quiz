package com.tw.qd.controller;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/{id}/educations")
    public List<Education> getEducationsByUserId(@PathVariable Long id) {
        return userService.getEducationsByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/{id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public Education createEducationByUserId(@PathVariable Long id, @RequestBody Education education) {
        return userService.createEducationByUserId(id, education);
    }
}
