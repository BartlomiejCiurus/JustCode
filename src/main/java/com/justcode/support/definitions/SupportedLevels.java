package com.justcode.support.definitions;

public enum SupportedLevels {

    BEGINNER("levels.beginner"),
    INTERMEDIATE("levels.intermediate"),
    ADVANCED("levels.advanced");

    private final String level;

    SupportedLevels(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return level;
    }

}
