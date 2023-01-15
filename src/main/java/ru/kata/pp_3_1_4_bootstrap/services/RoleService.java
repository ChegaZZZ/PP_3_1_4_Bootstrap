package ru.kata.pp_3_1_4_bootstrap.services;

import ru.kata.pp_3_1_4_bootstrap.models.Role;

import java.util.List;

public interface RoleService {
    void saveRole(Role role);

    List<Role> getAllRoles();
}