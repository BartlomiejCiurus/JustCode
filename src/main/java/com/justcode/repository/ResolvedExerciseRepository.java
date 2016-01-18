package com.justcode.repository;

import com.justcode.model.ResolvedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("resolvedExerciseRepository")
public interface ResolvedExerciseRepository extends JpaRepository<ResolvedExercise, Long>{

    @Query("SELECT resolvedExercise from ResolvedExercise resolvedExercise where resolvedExercise.user.id = ?1 and resolvedExercise.exercise.id = ?2")
    ResolvedExercise findResolvedExerciseById(Long userId, Long exerciseId);

}
