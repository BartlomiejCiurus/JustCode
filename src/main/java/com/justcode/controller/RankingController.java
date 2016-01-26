package com.justcode.controller;

import com.justcode.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RankingController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "ranking", method = RequestMethod.GET)
    public String getRanking(ModelMap modelMap){
        modelMap.put("usersList", userService.getRanking());

        return "ranking";
    }

    @RequestMapping(value = "rankingSearch", method = RequestMethod.GET)
    public String getRankingByName(@RequestParam String searchUsername, ModelMap modelMap){
        modelMap.put("usersList", userService.getRankingByName(searchUsername));

        return "ranking";
    }
}
