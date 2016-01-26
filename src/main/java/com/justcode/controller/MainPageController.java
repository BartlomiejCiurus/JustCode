package com.justcode.controller;

import com.justcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {

    @Autowired
    private UserService userService;

    @RequestMapping({"/index", "/home"})
    public String returnHomePage(ModelMap modelMap){
        Authentication userDetails =  SecurityContextHolder.getContext().getAuthentication();
        modelMap.put("usersNumber", userService.getUsersNumber());
        modelMap.put("user", userDetails.getName());

        return "home";
    }

}
