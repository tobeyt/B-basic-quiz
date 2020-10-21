package com.tw.qd.service;

import com.tw.qd.dto.User;
import com.tw.qd.exception.UserException;
import com.tw.qd.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id).orElseThrow(()->new UserException("用户不存在"));
    }
}
