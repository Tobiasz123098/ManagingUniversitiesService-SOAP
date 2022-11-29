package com.codeusingjava.uniwersytet.serwisy;

import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniwersytetSerwis {

    private final UniwersytetRepozytorium uniwersytetRepozytorium;

    @Autowired
    public UniwersytetSerwis(UniwersytetRepozytorium uniwersytetRepozytorium) {
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
    }

    //utworzenie metod
}
