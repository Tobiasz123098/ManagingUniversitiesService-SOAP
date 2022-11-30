package com.codeusingjava.dzien.serwisy;

import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DzienSerwis {

    private final DzienRepozytorium dzienRepozytorium;

    @Autowired
    public DzienSerwis(DzienRepozytorium dzienRepozytorium) {
        this.dzienRepozytorium = dzienRepozytorium;
    }

    //utworzenie metod
}
