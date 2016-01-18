package com.justcode.controller;

import com.justcode.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeleteTutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "deleteTutorial", method = RequestMethod.POST)
    public String deleteTutorial(@RequestParam String tutorialName){
        tutorialService.deleteTutorialByName(tutorialName);

        return "home";
    }

}
