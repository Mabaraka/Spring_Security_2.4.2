package web.service;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(1, "Max", 20));
        users.add(new User(2, "Tim", 22));
        users.add(new User(3, "Rik", 23));
        users.add(new User(4, "Tom", 21));
        users.add(new User(5, "Rob", 27));
    }

    public List<User> getUsers(int amount) {
        return users.stream().limit(amount).collect(Collectors.toList());
    }
}
