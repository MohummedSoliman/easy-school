package com.mohamed.easyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public String displayLoginPage(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model theModle) {
        String errorMessage = null;
        if (error != null) {
            errorMessage = "Username or Password is in correct";
        }
        if (logout != null) {
            errorMessage = "You Have been successfully logged out !!";
        }
        theModle.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }
}
