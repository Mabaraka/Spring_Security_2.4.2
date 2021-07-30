package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_ID;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_ID, "Max", 20));
        users.add(new User(++USER_ID, "Tim", 22));
        users.add(new User(++USER_ID, "Rik", 23));
        users.add(new User(++USER_ID, "Tom", 21));
        users.add(new User(++USER_ID, "Rob", 27));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id){
        return users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++USER_ID);
        users.add(user);
    }
}
