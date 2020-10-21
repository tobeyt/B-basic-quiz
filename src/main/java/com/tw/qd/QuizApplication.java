package com.tw.qd;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import com.tw.qd.service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuizApplication implements ApplicationRunner {

    private final UserService userService;

    public QuizApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(QuizApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.createUser(User.builder()
                .age(24L)
                .avatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, " +
                        "dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut " +
                        "fuga aliquam ad asperiores voluptatem dolorum! Quasi.")
                .name("KAMIL")
                .build());

        userService.createEducationByUserId(1L, Education.builder()
                .year(1990L)
                .title("I was born in Katowice")
                .description("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente, exercitationem, totam, dolores iste dolore est aut modi.")
                .userId(1L)
                .build());
        userService.createEducationByUserId(1L, Education.builder()
                .year(2005L)
                .title("Secondary school specializing in artistic")
                .description("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.")
                .userId(1L)
                .build());
        userService.createEducationByUserId(1L, Education.builder()
                .year(2009L)
                .title("First level graduation in Graphic Design")
                .description("Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat.")
                .userId(1L)
                .build());
        userService.createEducationByUserId(1L, Education.builder()
                .year(2012L)
                .title("Second level graduation in Graphic Design")
                .description("Ducimus, aliquam tempore autem itaque et accusantium!")
                .userId(1L)
                .build());
    }
}
