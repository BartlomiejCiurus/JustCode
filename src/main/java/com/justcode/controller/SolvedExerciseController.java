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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SolvedExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private UserService userService;

    @Autowired
    private ResolvedExerciseService resolvedExerciseService;

    @RequestMapping(value = "solvedExercise", method = RequestMethod.POST)
    public String solveExercise(@ModelAttribute ResolvedExercise resolvedExercise, @RequestParam String exerciseName){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByName(username);
        Exercise exercise = exerciseService.findExerciseByName(exerciseName);

        resolvedExercise.setUser(user);
        resolvedExercise.setExercise(exercise);

        resolvedExerciseService.save(resolvedExercise);
        userService.updateUserPoints(user.getId(), exercise.getPoints());

        return "home";
    }
}
