package com.justcode.controller;

import com.justcode.model.Exercise;
import com.justcode.service.ExerciseService;
import com.justcode.service.UserService;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import com.justcode.support.validator.ExerciseValidator;
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
public class AddExerciseController {

    public static final String EXERCISE_ADDED_MESSAGE_KEY = "exercise.add.done";

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private ExerciseValidator exerciseValidator;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "addExercise", method = RequestMethod.GET)
    public String addExercise(ModelMap modelMap) {
        modelMap.put("levelsList", SupportedLevels.values());
        modelMap.put("technologiesList", SupportedTechnologies.values());

        return "addExercise";
    }

    @RequestMapping(value = "addExercise", method = RequestMethod.POST)
    public String addTutorial(@ModelAttribute Exercise exercise, HttpServletRequest request, ModelMap modelMap) {
        exerciseValidator.setExercise(exercise);
        exerciseValidator.setLocale(RequestContextUtils.getLocale(request));
        ValidateResult validateResult = exerciseValidator.validate();

        if(!validateResult.isValid()){
            modelMap.put("errorMessage", validateResult.getMessage());
            modelMap.put("exercise", exercise);
            modelMap.put("levelsList", SupportedLevels.values());
            modelMap.put("technologiesList", SupportedTechnologies.values());
            return "addExercise";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        exercise.setAuthor(userService.getUserByName(username));
        exerciseService.save(exercise);

        modelMap.put("message", EXERCISE_ADDED_MESSAGE_KEY);

        return "home";
    }

}
