package com.justcode.support.validator;

import com.justcode.service.UserService;
import com.justcode.support.data.PostData;
import com.justcode.support.data.RegisterData;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class RegisterValidator {

    public static final String ERRORS_PASSWORD_SHORT = "errors.password.short";
    public static final String ERRORS_FIELDS_EMPTY = "errors.fields.empty";
    public static final String PASSWORD_ARE_NOT_THE_SAME_ERROR = "errors.password.not.same";
    public static final String PASSWORD_EMPTY_ERROR = "errors.password.empty";
    public static final String USERNAME_EMPTY_ERROR = "errors.username.empty";
    public static final String EMAIL_EMPTY_ERROR = "errors.email.empty";
    public static final String USERNAME_ALREADY_TAKEN_ERROR = "errors.username.taken";
    public static final String EMAIL_ALREADY_IN_USE = "errors.email.taken";

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private UserService userService;

    private ValidateResult validateResult;
    private RegisterData registerData;
    private Locale locale;

    public ValidateResult validate() {
        validateResult = new ValidateResult();

        validateIsPasswordNotTooShort();
        validateArePasswordsSameAndNotEmpty();
        validateIsEmailUsed();
        validateIsUsernameUsed();
        validateAreFieldsNotEmpty();

        return validateResult;
    }

    private void validateIsUsernameUsed() {
        if (StringUtils.isBlank(registerData.getUsername())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(USERNAME_EMPTY_ERROR, null, locale));
        }

        if (userService.getUserByName(registerData.getUsername()) != null) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(USERNAME_ALREADY_TAKEN_ERROR, null, locale));
        }
    }

    private void validateIsEmailUsed() {
        if (StringUtils.isBlank(registerData.getEmail())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(EMAIL_EMPTY_ERROR, null, locale));
        }

        if (userService.getUserByEmail(registerData.getEmail()) != null) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(EMAIL_ALREADY_IN_USE, null, locale));
        }

    }

    private void validateArePasswordsSameAndNotEmpty() {
        if (StringUtils.isBlank(registerData.getPassword()) || StringUtils.isBlank(registerData.getRepeatedPassword())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(PASSWORD_EMPTY_ERROR, null, locale));
        }

        if (!registerData.getPassword().equals(registerData.getRepeatedPassword())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(PASSWORD_ARE_NOT_THE_SAME_ERROR, null, locale));
        }
    }

    private void validateIsPasswordNotTooShort() {
        if (registerData.getPassword().length() < 6) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_PASSWORD_SHORT, null, locale));
        }
    }

    private void validateAreFieldsNotEmpty() {
        if (StringUtils.isBlank(registerData.getEmail()) || StringUtils.isBlank(registerData.getEmail())
                || StringUtils.isBlank(registerData.getEmail()) || StringUtils.isBlank(registerData.getEmail())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_FIELDS_EMPTY, null, locale));
        }

    }

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
