package com.justcode.repository;

import com.justcode.model.Tutorial;
import java.util.List;

import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("tutorialRepository")
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    @Query("SELECT tutorial from Tutorial tutorial where tutorial.technology = ?1")
    List<Tutorial> findTutorialsByTechnology(String technology);

    @Query("SELECT tutorial from Tutorial tutorial where tutorial.technology = ?1")
    List<Tutorial> findTutorialsByLevel(String level);

    @Query("SELECT tutorial from Tutorial tutorial where tutorial.name = ?1")
    Tutorial findTutorialByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Tutorial SET content = ?1, level = ?2, technology = ?3 WHERE name = ?4")
    void updateTutorialInfo(String content, SupportedLevels level, SupportedTechnologies technology, String tutorialName);

    @Modifying
    @Transactional
    @Query("DELETE Tutorial WHERE name = ?1")
    void deleteTutorialByName(String tutorialName);

    @Query("SELECT count(*) FROM Tutorial WHERE author.username = ?1")
    Long countNumberOfTutorialsByUsername(String username);
}
