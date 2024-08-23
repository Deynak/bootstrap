package com.deynak.bootstrap.controller;

import com.deynak.bootstrap.entity.User;
import com.deynak.bootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String userInfo(Principal principal, Model model) {
        User user = (User) userService.loadUserByUsername(principal.getName());
        if (user == null) {
            return "redirect:/";
        }
        model.addAttribute("currentUser", user);
        return "user";
    }
}
