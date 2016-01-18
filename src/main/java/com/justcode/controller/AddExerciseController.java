package com.justcode.controller;

import com.justcode.model.Exercise;
import com.justcode.service.ExerciseService;
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
public class AddExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addExercise", method = RequestMethod.GET)
    public String addExercise(ModelMap modelMap) {
        modelMap.put("levelsList", SupportedLevels.values());
        modelMap.put("technologiesList", SupportedTechnologies.values());

        return "addExercise";
    }

    @RequestMapping(value = "addExercise", method = RequestMethod.POST)
    public String addTutorial(@ModelAttribute Exercise exercise) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        exercise.setAuthor(userService.getUserByName(username));
        exerciseService.save(exercise);

        return "home";
    }

}
