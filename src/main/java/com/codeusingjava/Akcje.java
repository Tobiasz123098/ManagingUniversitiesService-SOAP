package com.codeusingjava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
public enum Akcje {
    CREATED("New student created"),
    DELETED("Student deleted"),
    EDITED("Student edited"),
    NOT_FOUND("There is no students with this id"),
    FAIL("Fail: ");

    @Getter
    private final String opis;

}
