package com.deynak.bootstrap.service;

import com.deynak.bootstrap.dao.RoleDAO;
import com.deynak.bootstrap.entity.Role;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;

    public RoleServiceImpl(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public List<Role> allRoles() {
        return roleDAO.allRoles();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public Role getRoleById(int id) {
        return roleDAO.getRoleById(id);
    }

    @Override
    public Role getDefaultRole() {
        return roleDAO.getDefaultRole();
    }

}
