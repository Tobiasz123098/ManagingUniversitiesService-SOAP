package com.codeusingjava.osiagniecie.serwisy;

import com.codeusingjava.osiagniecie.repozytoria.OsiagniecieRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsiagniecieSerwis {

    private final OsiagniecieRepozytorium osiagniecieRepozytorium;

    @Autowired
    public OsiagniecieSerwis(OsiagniecieRepozytorium osiagniecieRepozytorium) {
        this.osiagniecieRepozytorium = osiagniecieRepozytorium;
    }

    //utworzenie metod
}
