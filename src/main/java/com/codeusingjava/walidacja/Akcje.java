package com.codeusingjava.walidacja;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
