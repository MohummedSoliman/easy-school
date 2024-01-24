package com.mohamed.easyschool.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboardController {

    @RequestMapping("/dashboard")
    public String displayDashboard(Model theModel, Authentication authentication){
        theModel.addAttribute("username", authentication.getName());
        theModel.addAttribute("roles", authentication.getAuthorities().toArray());
        return "dashboard.html";
    }
}
