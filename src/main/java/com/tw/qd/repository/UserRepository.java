package com.tw.qd.repository;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Long generatedUserId = 0L;
    private final List<User> users = new ArrayList<>();

    private final List<Education> educations = new ArrayList<>();

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public List<Education> getEducationByUserId(Long id) {
        return educations.stream().filter(education -> education.getUserId().equals(id)).collect(Collectors.toList());
    }

    public Long getGeneratedUserId() {
        return ++generatedUserId;
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public Education createEducationByUserId(Education education) {
        educations.add(education);
        return education;
    }
}
