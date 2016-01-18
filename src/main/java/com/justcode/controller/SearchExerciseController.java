package com.justcode.controller;

import com.justcode.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @RequestMapping(value = "/searchExercise", method = RequestMethod.GET)
    public String searchTutorials(ModelMap modelMap){
        modelMap.put("exercisesList", exerciseService.findAll());

        return "searchExercise";
    }
}
