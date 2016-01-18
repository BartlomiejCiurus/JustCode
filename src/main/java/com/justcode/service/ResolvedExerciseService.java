package com.justcode.service;

import com.justcode.model.ResolvedExercise;
import com.justcode.repository.ResolvedExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("resolvedExerciseService")
public class ResolvedExerciseService {

    @Qualifier("resolvedExerciseRepository")
    @Autowired
    private ResolvedExerciseRepository resolvedExerciseRepository;

    @Transactional
    public ResolvedExercise save(ResolvedExercise resolvedExercise){
        return resolvedExerciseRepository.save(resolvedExercise);
    }

    public ResolvedExercise findResolvedExerciseById(Long userId, Long exerciseId){
        return resolvedExerciseRepository.findResolvedExerciseById(userId, exerciseId);
    }

}
