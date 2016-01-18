package com.justcode.controller;

import com.justcode.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchTutorialController {

    @Autowired
    private TutorialService tutorialService;

    @RequestMapping(value = "/searchTutorial", method = RequestMethod.GET)
    public String searchTutorials(ModelMap modelMap){
        modelMap.put("tutorialsList", tutorialService.findAll());

        return "searchTutorial";
    }

}
