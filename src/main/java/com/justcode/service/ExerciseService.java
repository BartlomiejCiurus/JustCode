package com.justcode.service;

import com.justcode.model.Exercise;
import com.justcode.repository.ExerciseRepository;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("exerciseService")
public class ExerciseService {

    @Qualifier("exerciseRepository")
    @Autowired
    private ExerciseRepository exerciseRepository;

    @Transactional
    public Exercise save(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> findExercisesByTechnology(SupportedTechnologies supportedTechnology) {
        return exerciseRepository.findExercisesByTechnology(supportedTechnology.toString());
    }

    public List<Exercise> findExercisesByLevel(SupportedLevels level) {
        return exerciseRepository.findExercisesByLevel(level.toString());
    }

    public Exercise findExerciseByName(String name) {
        return exerciseRepository.findExerciseByName(name);
    }

}
