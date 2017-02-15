package com.codeup.controllers;


import com.codeup.models.User;
import com.codeup.repositories.Users;
import com.codeup.services.UserSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsersController {
    @Autowired
    Users userDao;

    @Autowired
    UserSvc userSvc;


    private PasswordEncoder passwordEncoder;

    @GetMapping("/user/{id}")
    public String showUser(@PathVariable Long id, Model model){
        User user = userDao.findOne(id);
        model.addAttribute("user", user);
        model.addAttribute("showEditControls", userSvc.isLoggedIn());
        return "users/show";
    }
}
