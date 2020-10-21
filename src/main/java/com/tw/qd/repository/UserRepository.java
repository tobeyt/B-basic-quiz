package com.tw.qd.repository;

import com.tw.qd.dto.Education;
import com.tw.qd.dto.User;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private Long generatedUserId = 1L;
    private List<User> users = new ArrayList<User>() {
        {
            add(new User(
                    1L,
                    "KAMIL",
                    24L,
                    "https://inews.gtimg.com/newsapp_match/0/3581582328/0",
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, " +
                            "dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut " +
                            "fuga aliquam ad asperiores voluptatem dolorum! Quasi."
            ));
        }
    };

    private List<Education> educations = new ArrayList<Education>() {
        {

            add(new Education(
                    1L,
                    1990L,
                    "I was born in Katowice",
                    "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente, exercitationem, totam, dolores iste dolore est aut modi."
            ));
            add(new Education(
                    1L,
                    2005L,
                    "Secondary school specializing in artistic",
                    "Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus."
            ));
            add(new Education(
                    1L,
                    2009L,
                    "First level graduation in Graphic Design",
                    "Aspernatur, mollitia, quos maxime eius suscipit sed beatae ducimus quaerat quibusdam perferendis? Iusto, quibusdam asperiores unde repellat."
            ));
            add(new Education(
                    1L,
                    2012L,
                    "Second level graduation in Graphic Design",
                    "Ducimus, aliquam tempore autem itaque et accusantium!"
            ));

        }
    };

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
