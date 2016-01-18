package com.justcode.controller;

import com.justcode.model.Tutorial;
import com.justcode.service.TutorialService;
import com.justcode.service.UserService;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddTutorialController {

    @Autowired
    private TutorialService tutorialService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addTutorial", method = RequestMethod.GET)
    public String addTutorial(ModelMap modelMap){
        modelMap.put("levelsList", SupportedLevels.values());
        modelMap.put("technologiesList", SupportedTechnologies.values());

        return "addTutorial";
    }

    @RequestMapping(value = "addTutorial", method = RequestMethod.POST)
    public String addTutorial(@ModelAttribute Tutorial tutorial){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        tutorial.setAuthor(userService.getUserByName(username));
        tutorialService.save(tutorial);

        return "home";
    }

}
