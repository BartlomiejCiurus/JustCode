package com.justcode.support.validator;

import com.justcode.model.Tutorial;
import com.justcode.service.TutorialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class TutorialValidator {

    public static final String ERRORS_FIELDS_EMPTY = "errors.fields.empty";
    public static final String ERRORS_TUTORIAL_NAME_TAKEN = "errors.tutorial.name.taken";

    @Autowired
    private TutorialService tutorialService;
    @Autowired
    private MessageSource messageSource;

    private ValidateResult validateResult;
    private Tutorial tutorial;
    private Locale locale;

    public ValidateResult validate() {
        validateResult = new ValidateResult();

        validateIsNameUsed();
        validateAreFieldsNotEmpty();

        return validateResult;
    }

    private void validateIsNameUsed() {
        if(tutorialService.findTutorialByName(tutorial.getName()) != null){
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_TUTORIAL_NAME_TAKEN, null, locale));
        }
    }

    private void validateAreFieldsNotEmpty() {
        if(StringUtils.isBlank(tutorial.getName()) || StringUtils.isBlank(tutorial.getContent())){
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_FIELDS_EMPTY, null, locale));
        }
    }

    public Tutorial getTutorial() {
        return tutorial;
    }

    public void setTutorial(Tutorial tutorial) {
        this.tutorial = tutorial;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
