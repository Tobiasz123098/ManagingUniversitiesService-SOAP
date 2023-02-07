package com.codeusingjava.student.wyjatki;

public class NieMoznaWyswietlicStudentaPoId extends RuntimeException {

    public NieMoznaWyswietlicStudentaPoId(Exception e) {
        super(e);
    }

    public NieMoznaWyswietlicStudentaPoId(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
