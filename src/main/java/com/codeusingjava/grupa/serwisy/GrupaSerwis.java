package com.codeusingjava.grupa.serwisy;

import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaSerwis {

    private final GrupaRepozytorium grupaRepozytorium;

    @Autowired
    public GrupaSerwis(GrupaRepozytorium grupaRepozytorium) {
        this.grupaRepozytorium = grupaRepozytorium;
    }

    //utworzenie metod
}
