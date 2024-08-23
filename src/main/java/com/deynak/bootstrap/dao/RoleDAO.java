package com.deynak.bootstrap.dao;

import com.deynak.bootstrap.entity.Role;

import java.util.List;


public interface RoleDAO {

    List<Role> allRoles();

    Role getRoleById(int id);

    Role getRoleByName(String name);

    Role getDefaultRole();
}