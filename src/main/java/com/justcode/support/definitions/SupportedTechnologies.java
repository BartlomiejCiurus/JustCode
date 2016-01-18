package com.justcode.support.definitions;

public enum SupportedTechnologies {

    JAVA_LANGUAGE("JAVA"),
    C_LANGUAGE("C/C++"),
    RUBY_LANGUAGE("RUBY"),
    PYTHON_LANGUAGE("PYTHON");

    private final String technology;

    SupportedTechnologies(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return technology;
    }
}
