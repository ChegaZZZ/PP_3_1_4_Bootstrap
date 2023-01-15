package ru.kata.pp_3_1_4_bootstrap.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.pp_3_1_4_bootstrap.models.Role;
import ru.kata.pp_3_1_4_bootstrap.models.User;
import ru.kata.pp_3_1_4_bootstrap.services.RoleService;
import ru.kata.pp_3_1_4_bootstrap.services.UserService;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class Initializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Initializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void init() {
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user1 = new User("Dmitry", "Chigir", 26, "admin", "admin",
                new HashSet<>(Set.of(role1)));

        User user2 = new User("Maria", "Chigir", 28, "user", "user",
                new HashSet<>(Set.of(role2)));

        userService.saveUser(user1);
        userService.saveUser(user2);
    }
}