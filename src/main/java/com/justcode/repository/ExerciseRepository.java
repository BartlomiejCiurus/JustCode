package com.justcode.repository;

import com.justcode.model.Exercise;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("exerciseRepository")
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    @Query("SELECT exercise from Exercise exercise where exercise.technology = ?1")
    List<Exercise> findExercisesByTechnology(String technology);

    @Query("SELECT exercise from Exercise exercise where exercise.level = ?1")
    List<Exercise> findExercisesByLevel(String Level);

    @Query("SELECT exercise from Exercise exercise where exercise.name = ?1")
    Exercise findExerciseByName(String name);

    @Query("SELECT count(*) FROM Exercise WHERE author.username = ?1")
    Long countNumberOfExercisesByUsername(String username);

}
