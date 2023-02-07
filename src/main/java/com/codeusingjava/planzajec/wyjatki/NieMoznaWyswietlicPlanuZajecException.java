package com.codeusingjava.planzajec.wyjatki;

public class NieMoznaWyswietlicPlanuZajecException extends RuntimeException {

    public NieMoznaWyswietlicPlanuZajecException(Exception e) {
        super(e);
    }

    public NieMoznaWyswietlicPlanuZajecException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
