package com.codeusingjava.planzajec.serwisy;

import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanZajecSerwis {

    private final PlanZajecRepozytorium planZajecRepozytorium;

    @Autowired
    public PlanZajecSerwis(PlanZajecRepozytorium planZajecRepozytorium) {
        this.planZajecRepozytorium = planZajecRepozytorium;
    }

    //utworzenie metod
}
