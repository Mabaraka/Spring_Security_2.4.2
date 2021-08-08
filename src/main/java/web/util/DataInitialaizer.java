package web.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.models.Role;
import web.models.User;
import web.service.RoleService;
import web.service.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInitialaizer {

    private UserService userService;
    private RoleService roleService;

    public DataInitialaizer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void Init() {
        Role roleAdmin = new Role(1,"ROLE_ADMIN");
        Role roleUser = new Role(2,"ROLE_USER");

        Set<Role> allRoles = new HashSet<>();
        allRoles.add(roleAdmin);
        allRoles.add(roleUser);

        for (Role role: allRoles) {
            roleService.save(role);
        }

        User admin = new User("Bob","pass",21);
        admin.setRoles(allRoles);
        userService.save(admin);

        User user = new User("Rik","pass",20);
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleService.getRoleById(2));
        user.setRoles(userRoles);
        userService.save(user);
    }
}