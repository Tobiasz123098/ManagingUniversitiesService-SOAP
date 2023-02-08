package com.codeusingjava.student.wyjatki;

public class NieMoznaWyswietlicStudentaPoIdException extends RuntimeException {

    public NieMoznaWyswietlicStudentaPoIdException(String message) {
        super(message);
    }

    public NieMoznaWyswietlicStudentaPoIdException(Exception e) {
        super(e);
    }

    public NieMoznaWyswietlicStudentaPoIdException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
