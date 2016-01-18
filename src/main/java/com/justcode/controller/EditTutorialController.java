package com.justcode.controller;

import com.justcode.model.Tutorial;
import com.justcode.service.TutorialService;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditTutorialController {

    @Autowired
    private TutorialService tutorialService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "editTutorial", method = RequestMethod.GET)
    public String editTutorial(@RequestParam String tutorialName, ModelMap modelMap) {
        Tutorial tutorial = tutorialService.findTutorialByName(tutorialName);
        modelMap.put("levelsList", SupportedLevels.values());
        modelMap.put("technologiesList", SupportedTechnologies.values());
        modelMap.put("tutorial", tutorial);

        return "editTutorial";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "editTutorial", method = RequestMethod.POST)
    public String editTutorial(@ModelAttribute Tutorial tutorial) {
        tutorialService.updateTutorialInfo(tutorial.getContent(), tutorial.getLevel(), tutorial.getTechnology(), tutorial.getName());

        return "home";
    }


}
