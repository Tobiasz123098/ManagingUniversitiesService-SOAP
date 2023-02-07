package com.codeusingjava.prowadzacy.wyjatki;

public class NieMoznaWyswietlicProwadzacychException extends RuntimeException {

    public NieMoznaWyswietlicProwadzacychException(Exception e) {
        super(e);
    }

    public NieMoznaWyswietlicProwadzacychException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
