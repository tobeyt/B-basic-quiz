package com.tw.qd.service;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.exception.UserException;
import com.tw.qd.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(() -> new UserException("用户不存在"));
    }

    public List<Education> getEducationsByUserId(Long id) {
        return userRepository.getEducationByUserId(id);
    }

    public Long createUser(User user) {
        user.setId(userRepository.getGeneratedUserId());
        return userRepository.createUser(user);
    }

    public void createEducationByUserId(Long id, Education education) {
        userRepository.getUserById(id).orElseThrow(() -> new UserException("用户不存在"));
        System.out.println("这里被执行了");
        education.setUserId(id);
        userRepository.createEducationByUserId(education);
    }
}
