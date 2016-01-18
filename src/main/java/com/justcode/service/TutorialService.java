package com.justcode.service;

import com.justcode.model.Tutorial;
import com.justcode.repository.TutorialRepository;
import com.justcode.support.definitions.SupportedLevels;
import com.justcode.support.definitions.SupportedTechnologies;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("tutorialService")
public class TutorialService {

    @Qualifier("tutorialRepository")
    @Autowired
    private TutorialRepository tutorialRepository;

    @Transactional
    public Tutorial save(Tutorial tutorial){
        return tutorialRepository.save(tutorial);
    }

    public List<Tutorial> findAll(){
        return tutorialRepository.findAll();
    }

    public List<Tutorial> findTutorialsByTechnology(SupportedTechnologies supportedTechnology) {
        return tutorialRepository.findTutorialsByTechnology(supportedTechnology.toString());
    }

    public List<Tutorial> findTutorialsByLevel(SupportedLevels level) {
        return tutorialRepository.findTutorialsByLevel(level.toString());
    }

    public Tutorial findTutorialByName(String name){
        return tutorialRepository.findTutorialByName(name);
    }


}
