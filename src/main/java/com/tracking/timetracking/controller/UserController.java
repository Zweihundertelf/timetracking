package com.tracking.timetracking.controller;

import com.tracking.timetracking.model.UserModel;
import com.tracking.timetracking.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new UserModel());
        return "register_page";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new UserModel());
        return "login_page";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute UserModel userModel) {
        System.out.println("register: " + userModel);
        UserModel registeredUser = userService.registerUser(userModel.getName(), userModel.getPassword(), userModel.getRepeatPassword(), userModel.getEmail());
        return registeredUser == null ? "error_page" : "redirect:/auth/login";
    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute UserModel userModel, Model model) {
        System.out.println("login: " + userModel);
        UserModel authenticated = userService.authenticate(userModel.getName(), userModel.getPassword());
        if(authenticated != null) {
            return "private_page";
        } else {
            return "error_page";
        }
    }
}
