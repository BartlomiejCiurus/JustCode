package com.justcode.controller;

import com.justcode.model.Exercise;
import com.justcode.model.ResolvedExercise;
import com.justcode.model.User;
import com.justcode.service.ExerciseService;
import com.justcode.service.ResolvedExerciseService;
import com.justcode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExerciseViewController {

    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private ResolvedExerciseService resolvedExerciseService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/viewExercise", method = RequestMethod.GET)
    public String viewExercise(@RequestParam String exerciseName, ModelMap modelMap) {
        Exercise exercise = exerciseService.findExerciseByName(exerciseName);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByName(username);
        ResolvedExercise resolvedExercise = resolvedExerciseService.findResolvedExerciseById(user.getId(), exercise.getId());

        modelMap.put("exercise", exercise);
        modelMap.put("resolvedExercise", resolvedExercise);
        return "viewExercise";
    }
}
