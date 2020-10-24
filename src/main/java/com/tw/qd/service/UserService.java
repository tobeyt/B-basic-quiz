package com.tw.qd.service;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.entity.UserEntity;
import com.tw.qd.exception.UserException;
import com.tw.qd.repository.EducationRepository;
import com.tw.qd.repository.UserRepository;
import com.tw.qd.tool.Convert;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EducationRepository educationRepository;

    public UserService(UserRepository userRepository, EducationRepository educationRepository) {
        this.userRepository = userRepository;
        this.educationRepository = educationRepository;
    }

    public User getUserById(Long id) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserException("用户不存在"));
        return Convert.convetToUserDto(userEntity);
    }

    public List<Education> getEducationsByUserId(Long id) {
        userRepository.findById(id).orElseThrow(() -> new UserException("用户不存在"));
        return educationRepository.findAllByUserEntityId(id).stream()
                .map(Convert::convetToEducationDto).collect(Collectors.toList());
    }

    public User createUser(User user) {
        UserEntity savedUser = userRepository.save(Convert.converToUserEntity(user));
        user.setId(savedUser.getId());
        return user;
    }

    public Education createEducationByUserId(Long id, Education education) {
        UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new UserException("用户不存在"));
        educationRepository.save(Convert.convertToEducationEntity(education, userEntity));
        education.setUserId(id);
        return education;
    }
}
