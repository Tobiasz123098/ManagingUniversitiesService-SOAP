package com.codeusingjava.index.serwisy;

import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexSerwis {

    private final IndexRepozytorium indexRepozytorium;

    @Autowired
    public IndexSerwis(IndexRepozytorium indexRepozytorium) {
        this.indexRepozytorium = indexRepozytorium;
    }

    //utworzenie metod
}
