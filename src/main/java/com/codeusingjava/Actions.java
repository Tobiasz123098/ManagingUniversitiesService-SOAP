package com.codeusingjava;

public enum Actions {
    CREATED("New student created"),
    DELETED("Student deleted"),
    EDITED("Student edited"),
    NOT_FOUND("There is no students with this id"),
    FAIL("Fail: ");

    private final String actionDescription;
    Actions(String actionDescription) {
        this.actionDescription = actionDescription;
    }

    public String getActionDescription() {
        return actionDescription;
    }


    @Override
    public String toString() {
        return actionDescription;
    }
}
