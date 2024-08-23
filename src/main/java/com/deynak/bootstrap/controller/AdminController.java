package com.deynak.bootstrap.controller;

import com.deynak.bootstrap.entity.Role;
import com.deynak.bootstrap.entity.User;
import com.deynak.bootstrap.service.RoleService;
import com.deynak.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.HashSet;
import java.util.Set;


@Controller
@RequestMapping("/admin")

public class AdminController {

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/all")
    public String allUsers(Principal principal, ModelMap modelMap) {
        modelMap.addAttribute("currentUser", userService.loadUserByUsername(principal.getName()));
        modelMap.addAttribute("allUsers", userService.getAllUsers());
        modelMap.addAttribute("allRoles", roleService.allRoles());
        modelMap.addAttribute("newUser", new User());
        return "allUsersPage";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") User user, @RequestParam("editUserRoleId") int editUserRoleId) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(editUserRoleId));
        user.setRoles(roles);
        userService.saveUser(user);
        return "redirect:/all";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("userId") int id) {
        userService.deleteUser(id);
        return "redirect:/all";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("newUser") User user, @RequestParam("newUserRoleId") int newUserRoleId) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getRoleById(newUserRoleId));
        user.setRoles(roles);
        userService.saveUser(user);
        return "redirect:/all";
    }
}

