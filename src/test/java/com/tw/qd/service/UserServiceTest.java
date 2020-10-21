package com.tw.qd.service;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.exception.UserException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void should_get_user_by_id() {
        User user = userService.getUserById(1L);
        assertEquals(user.getAge(), 24);
        assertEquals(user.getName(), "KAMIL");
    }

    @Test
    void should_throw_exception_when_user_not_exists() {
        UserException userException = assertThrows(UserException.class, () -> userService.getUserById(10L));
        assertEquals("用户不存在", userException.getMessage());
    }

    @Test
    void should_get_educations_by_userId() {
        List<Education> educations = userService.getEducationsByUserId(1L);
        assertEquals(educations.get(0).getYear(), 1990);
        assertEquals(educations.get(1).getYear(), 2005);
    }

    @Test
    void should_throw_exception_when_user_not_exists_with_get_educations_function() {
        UserException userException = assertThrows(UserException.class, () -> userService.getEducationsByUserId(10L));
        assertEquals("用户不存在", userException.getMessage());
    }

    @Test
    void should_create_user() {
        User user = userService.createUser(User.builder()
                .age(20L)
                .name("覃狄")
                .avatar("www.thoughtworks.com")
                .description("TWer")
                .build());
        assertEquals(user.getId(), 2);
        assertEquals(user.getName(), "覃狄");
    }

    @Test
    void should_create_education_by_user_id() {
        Education education = userService.createEducationByUserId(1L, Education.builder()
                .description("TW最好的大学")
                .year(2020L)
                .title("TWU")
                .build());
        assertEquals(education.getUserId(), 1);
        assertEquals(education.getYear(), 2020);
    }
}