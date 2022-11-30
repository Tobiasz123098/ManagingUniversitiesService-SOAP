package com.codeusingjava.sala.serwisy;

import com.codeusingjava.sala.repozytoria.SalaRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaSerwis {

    private final SalaRepozytorium salaRepozytorium;

    @Autowired
    public SalaSerwis(SalaRepozytorium salaRepozytorium) {
        this.salaRepozytorium = salaRepozytorium;
    }

    //utworzenie metod
}
