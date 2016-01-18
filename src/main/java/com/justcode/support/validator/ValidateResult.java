package com.justcode.support.validator;

public class ValidateResult {

    private boolean isValid = true;
    private String message;

    public boolean isValid() {
        return isValid;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final ValidateResult result = (ValidateResult) o;

        return isValid == result.isValid && !(message != null ? !message.equals(result.message) :
            result.message != null);

    }

    @Override
    public int hashCode() {
        int result = (isValid ? 1 : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }
}
