package com.justcode.controller;

import com.justcode.model.Tutorial;
import com.justcode.service.TutorialService;
import com.justcode.service.UserService;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import com.justcode.support.validator.TutorialValidator;
import com.justcode.support.validator.ValidateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddTutorialController {

    public static final String TUTORIAL_ADDED_MESSAGE_KEY = "tutorial.add.done";

    @Autowired
    private TutorialService tutorialService;

    @Autowired
    private TutorialValidator tutorialValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addTutorial", method = RequestMethod.GET)
    public String addTutorial(ModelMap modelMap){
        modelMap.put("levelsList", SupportedLevels.values());
        modelMap.put("technologiesList", SupportedTechnologies.values());

        return "addTutorial";
    }

    @RequestMapping(value = "addTutorial", method = RequestMethod.POST)
    public String addTutorial(@ModelAttribute Tutorial tutorial, HttpServletRequest request, ModelMap modelMap){
        tutorialValidator.setTutorial(tutorial);
        tutorialValidator.setLocale(RequestContextUtils.getLocale(request));
        ValidateResult validateResult = tutorialValidator.validate();

        if (!validateResult.isValid()){
            modelMap.put("errorMessage", validateResult.getMessage());
            modelMap.put("tutorial", tutorial);
            modelMap.put("levelsList", SupportedLevels.values());
            modelMap.put("technologiesList", SupportedTechnologies.values());
            return "addTutorial";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        tutorial.setAuthor(userService.getUserByName(username));
        tutorialService.save(tutorial);

        modelMap.put("message", TUTORIAL_ADDED_MESSAGE_KEY);

        return "home";
    }

}
