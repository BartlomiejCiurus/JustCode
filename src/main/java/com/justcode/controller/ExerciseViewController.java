package com.justcode.controller;

import com.justcode.model.Exercise;
import com.justcode.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExerciseViewController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/viewExercise",method = RequestMethod.GET)
    public String viewExercise(@RequestParam String exerciseName, ModelMap modelMap){
        Exercise exercise = exerciseService.findExerciseByName(exerciseName);
        modelMap.put("exercise", exercise);

        return "viewExercise";
    }
}
