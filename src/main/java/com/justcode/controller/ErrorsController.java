package com.justcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController {

    @RequestMapping(value = "/404")
    public String returnPageNotFoundError(){
        return "404";
    }

    @RequestMapping(value = "/403")
    public String return403Error(){
        return "403";
    }
}
