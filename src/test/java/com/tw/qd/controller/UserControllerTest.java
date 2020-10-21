package com.tw.qd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Objects;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private User user;
    private Education education;

    @BeforeEach
    void init() {
        user = User.builder()
                .name("覃狄")
                .description("TWer")
                .avatar("www.thoughtworks.com.cn")
                .age(22L)
                .build();

        education = Education.builder()
                .description("这是我的简介")
                .title("北京大学")
                .year(2020L)
                .build();
    }

    @Test
    void should_get_user_by_id() throws Exception {
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("KAMIL")));
    }

    @Test
    void should_throw_exception_when_user_not_exist() throws Exception {
        mockMvc.perform(get("/users/2"))
                .andExpect(result -> assertEquals("用户不存在", Objects.requireNonNull(result.getResolvedException()).getMessage()))
                .andExpect(status().isNotFound());
    }

    @Test
    void should_get_educations_by_userId() throws Exception {
        mockMvc.perform(get("/users/1/educations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].year", is(2009)));
    }

    @Test
    void should_throw_exception_when_user_not_exist_for_get_educations_by_userId() throws Exception {
        mockMvc.perform(get("/users/3/educations"))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertEquals("用户不存在", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    void should_create_user() throws Exception {
        String jsonOfUser = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/users")
                .content(jsonOfUser).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is("覃狄")))
                .andExpect(status().isCreated());
    }

    @Test
    void should_get_valid_exception_when_user_invalid() throws Exception {
        user.setAge(10L);
        String jsonOfUser = objectMapper.writeValueAsString(user);

        mockMvc.perform(post("/users")
                .content(jsonOfUser).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_create_education_by_userId() throws Exception {
        String jsonOfEducation = objectMapper.writeValueAsString(education);

        mockMvc.perform(post("/users/1/educations")
                .content(jsonOfEducation).contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title", is("北京大学")))
                .andExpect(status().isCreated());

    }

    @Test
    void should_throw_exception_when_create_education_by_userId_but_userId_not_exist() throws Exception {
        String jsonOfEducation = objectMapper.writeValueAsString(education);

        mockMvc.perform(post("/users/2/educations")
                .content(jsonOfEducation).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertEquals("用户不存在", Objects.requireNonNull(result.getResolvedException()).getMessage()));
    }

    @Test
    void should_throw_exception_when_create_education_by_userId_with_invalid_fields() throws Exception {
        education.setTitle("");
        String jsonOfEducation = objectMapper.writeValueAsString(education);

        mockMvc.perform(post("/users/1/educations")
                .content(jsonOfEducation).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}