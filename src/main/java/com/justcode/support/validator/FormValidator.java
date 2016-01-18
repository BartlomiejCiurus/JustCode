package com.justcode.support.validator;

import com.justcode.support.data.PostData;
import java.util.Locale;

public interface FormValidator {
    ValidateResult validate(PostData postData, Locale locale);
}
