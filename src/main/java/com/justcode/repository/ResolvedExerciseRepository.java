package com.justcode.repository;

import com.justcode.model.ResolvedExercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("resolvedExerciseRepository")
public interface ResolvedExerciseRepository extends JpaRepository<ResolvedExercise, Long>{

}
