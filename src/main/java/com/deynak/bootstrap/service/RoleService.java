package com.deynak.bootstrap.service;

import com.deynak.bootstrap.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    Role getRoleByName(String name);

    Role getRoleById(int id);

    Role getDefaultRole();
}
