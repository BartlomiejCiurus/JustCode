package com.justcode.support.validator;

import com.justcode.service.UserService;
import com.justcode.support.data.PostData;
import com.justcode.support.data.RegisterData;

import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class RegisterValidator implements FormValidator {

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
    private Locale locale;

    public ValidateResult validate(PostData postData, Locale locale) {
        RegisterData registerData = (RegisterData) postData;
        validateResult = new ValidateResult();
        this.locale = locale;

        validateIsPasswordNotTooShort(registerData.getPassword());
        validateArePasswordsSameAndNotEmpty(registerData.getPassword(), registerData.getRepeatedPassword());
        validateIsEmailUsed(registerData.getEmail());
        validateIsUsernameUsed(registerData.getUsername());
        validateAreFieldsNotEmpty(registerData);

        return validateResult;
    }

    private void validateIsUsernameUsed(String username) {
        if (StringUtils.isBlank(username)) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(USERNAME_EMPTY_ERROR, null, locale));
        }

        if (userService.getUserByName(username) != null) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(USERNAME_ALREADY_TAKEN_ERROR, null, locale));
        }
    }

    private void validateIsEmailUsed(String email) {
        if (StringUtils.isBlank(email)) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(EMAIL_EMPTY_ERROR, null, locale));
        }

        if (userService.getUserByEmail(email) != null) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(EMAIL_ALREADY_IN_USE, null, locale));
        }

    }

    private void validateArePasswordsSameAndNotEmpty(String password, String repeatedPassword) {
        if (StringUtils.isBlank(password) || StringUtils.isBlank(repeatedPassword)) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(PASSWORD_EMPTY_ERROR, null, locale));
        }

        if (!password.equals(repeatedPassword)) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(PASSWORD_ARE_NOT_THE_SAME_ERROR, null, locale));
        }
    }

    private void validateIsPasswordNotTooShort(String password) {
        if (password.length() < 6) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_PASSWORD_SHORT, null, locale));
        }
    }

    private void validateAreFieldsNotEmpty(RegisterData registerData) {
        if (StringUtils.isBlank(registerData.getEmail()) || StringUtils.isBlank(registerData.getEmail())
                || StringUtils.isBlank(registerData.getEmail()) || StringUtils.isBlank(registerData.getEmail())) {
            validateResult.setIsValid(false);
            validateResult.setMessage(messageSource.getMessage(ERRORS_FIELDS_EMPTY, null, locale));
        }

    }
}
