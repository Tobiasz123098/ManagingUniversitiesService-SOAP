package com.codeusingjava.stypendium.serwisy;

import com.codeusingjava.stypendium.repozytoria.StypendiumRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StypendiumSerwis {

    private final StypendiumRepozytorium stypendiumRepozytorium;

    @Autowired
    public StypendiumSerwis(StypendiumRepozytorium stypendiumRepozytorium) {
        this.stypendiumRepozytorium = stypendiumRepozytorium;
    }

    //utworzenie metod
}
