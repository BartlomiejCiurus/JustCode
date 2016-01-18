package com.justcode.controller;

import com.justcode.model.Tutorial;
import com.justcode.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TutorialViewController {

    @Autowired
    private TutorialService tutorialService;

    @RequestMapping(value = "/viewTutorial", method = RequestMethod.GET)
    public String viewTutorial(@RequestParam String tutorialName, ModelMap modelMap){
        Tutorial tutorial = tutorialService.findTutorialByName(tutorialName);
        modelMap.put("tutorial", tutorial);

        return "viewTutorial";
    }

}
