package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.Role;
import web.models.User;
import web.service.UserService;

import java.util.HashSet;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("Users", userService.index());
        return "index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "admin_show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(required = false ,name = "ADMIN") String ADMIN,
                         @RequestParam(required = false ,name = "USER") String USER) {

        HashSet<Role> roles = new HashSet();

        if (ADMIN != null) {
            roles.add(new Role(1, ADMIN));
        }
        if (USER != null) {
            roles.add(new Role(2, USER));
        }
        if (ADMIN == null && USER == null) {
            roles.add(new Role(2, USER));
        }
        user.setRoles(roles);

        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user,
                         @PathVariable("id") int id,
                         @RequestParam(required = false ,name = "ADMIN") String ADMIN,
                         @RequestParam(required = false , name = "USER") String USER) {

        HashSet<Role> roles = new HashSet();

        if (ADMIN != null) {
            roles.add(new Role(1, ADMIN));
        }
        if (USER != null) {
            roles.add(new Role(2, USER));
        }
        if (ADMIN == null && USER == null) {
            roles.add(new Role(2, USER));
        }
        user.setRoles(roles);

        userService.update(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

}