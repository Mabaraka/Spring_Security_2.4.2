package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.UserService;
import web.models.User;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String carView(@RequestParam(defaultValue = "5") int count, Model model) {

        List<User> userList = userService.getUsers(count);

        model.addAttribute("Users", userList);

        return "users";
    }
}
