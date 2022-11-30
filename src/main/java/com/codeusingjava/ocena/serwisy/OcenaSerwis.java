package com.codeusingjava.ocena.serwisy;

import com.codeusingjava.ocena.repozytoria.OcenaRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcenaSerwis {

    private final OcenaRepozytorium ocenaRepozytorium;

    @Autowired
    public OcenaSerwis(OcenaRepozytorium ocenaRepozytorium) {
        this.ocenaRepozytorium = ocenaRepozytorium;
    }

    //utworzenie metod
}
