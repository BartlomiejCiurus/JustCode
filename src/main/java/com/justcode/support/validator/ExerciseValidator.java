package com.justcode.support.validator;

import com.justcode.model.Exercise;
import com.justcode.service.ExerciseService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class ExerciseValidator {

    public static final String ERRORS_FIELDS_EMPTY = "errors.fields.empty";

    @Autowired
    private ExerciseService exerciseService;
    @Autowired
    private MessageSource messageSource;

    private ValidateResult validateResult;
    private Exercise exercise;
    private Locale locale;

    public ValidateResult validate() {
        validateResult = new ValidateResult();

        validateIsNameUsed();
        validateAreFieldsNotEmpty();

        return validateResult;
    }

    private void validateAreFieldsNotEmpty() {
        if(StringUtils.isBlank(exercise.getName()) || StringUtils.isBlank(exercise.getDescription()) || exercise.getPoints() < 1){
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_FIELDS_EMPTY, null, locale));
        }
    }

    private void validateIsNameUsed() {
        if(exerciseService.findExerciseByName(exercise.getName()) != null){
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage("errors.exercise.name.taken", null, locale));
        }
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
