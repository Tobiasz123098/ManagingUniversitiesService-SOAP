package com.codeusingjava.przedmiot.serwisy;

import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrzedmiotSerwis {

    private final PrzedmiotRepozytorium przedmiotRepozytorium;

    @Autowired
    public PrzedmiotSerwis(PrzedmiotRepozytorium przedmiotRepozytorium) {
        this.przedmiotRepozytorium = przedmiotRepozytorium;
    }

    //utworzenie metod
}
