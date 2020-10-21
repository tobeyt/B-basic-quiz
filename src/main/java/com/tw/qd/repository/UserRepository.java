package com.tw.qd.repository;

import com.tw.qd.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
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

    public Optional<User> getUserById(Long id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
