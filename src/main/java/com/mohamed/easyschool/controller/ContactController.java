package com.mohamed.easyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String displayContactPage(){
        return "contact";
    }

    @RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
    public ModelAndView saveMessage(){
        return new ModelAndView("redirect:/contact");
    }
}
