package com.codeusingjava.index.serwisy;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.sruuniwersytet.DodajIndexDoGrupyOdpowiedz;
import com.sruuniwersytet.DodajIndexDoGrupyZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class IndexSerwis {

    private final IndexRepozytorium indexRepozytorium;

    private final GrupaRepozytorium grupaRepozytorium;

    @Autowired
    public IndexSerwis(IndexRepozytorium indexRepozytorium,
                       GrupaRepozytorium grupaRepozytorium) {
        this.indexRepozytorium = indexRepozytorium;
        this.grupaRepozytorium = grupaRepozytorium;
    }

    @Transactional
    public DodajIndexDoGrupyOdpowiedz dodajIndexDoGrupy(DodajIndexDoGrupyZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajIndexDoGrupyOdpowiedz response = factory.createDodajIndexDoGrupyOdpowiedz();

        try {
            Index index = indexRepozytorium.findOne(req.getIdIndexu());
            Grupa grupa = grupaRepozytorium.findOne(req.getIdGrupy());

            index.setGrupa(grupa);
            index = indexRepozytorium.save(index);

            response.setIdObiektu(index.getId());
            response.setWynikWalidacji("Dodano index do grupy");
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
