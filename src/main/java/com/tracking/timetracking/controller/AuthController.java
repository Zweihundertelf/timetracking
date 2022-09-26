package com.tracking.timetracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "register_page";
    }

    @GetMapping(value = "/login")
    public String getLoginPage() {
        return "login_page";
    }
}
