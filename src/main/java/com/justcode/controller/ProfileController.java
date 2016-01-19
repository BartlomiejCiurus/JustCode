package com.justcode.controller;

import com.justcode.service.ExerciseService;
import com.justcode.service.TutorialService;
import com.justcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String getRanking(ModelMap modelMap){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.put("user", userService.getUserByName(username));
        modelMap.put("tutorialsCreated", tutorialService.countNumberOfTutorialsByUsername(username));
        modelMap.put("exercisesCreated", exerciseService.countNumberOfExercisesByUsername(username));

        return "profile";
    }

}
