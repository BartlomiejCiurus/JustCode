package com.justcode.repository;

import com.justcode.model.Tutorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("tutorialRepository")
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    @Query("SELECT tutorial from Tutorial tutorial where tutorial.technology = ?1")
    List<Tutorial> findTutorialsByTechnology(String technology);

    @Query("SELECT tutorial from Tutorial tutorial where tutorial.technology = ?1")
    List<Tutorial> findTutorialsByLevel(String level);

    @Query("SELECT tutorial from Tutorial tutorial where tutorial.name = ?1")
    Tutorial findTutorialByName(String name);
}
