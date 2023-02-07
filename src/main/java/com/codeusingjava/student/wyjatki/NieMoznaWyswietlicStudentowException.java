package com.codeusingjava.student.wyjatki;

public class NieMoznaWyswietlicStudentowException extends RuntimeException {

    public NieMoznaWyswietlicStudentowException(Exception e) {
        super(e);
    }

    public NieMoznaWyswietlicStudentowException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
