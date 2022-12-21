package com.codeusingjava.ocena.serwisy;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.codeusingjava.ocena.domena.Ocena;
import com.codeusingjava.ocena.repozytoria.OcenaRepozytorium;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzOceneOdpowiedz;
import com.sruuniwersytet.UtworzOceneZapytanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcenaSerwis {

    private final OcenaRepozytorium ocenaRepozytorium;

    private final IndexRepozytorium indexRepozytorium;

    private final DzienRepozytorium dzienRepozytorium;

    @Autowired
    public OcenaSerwis(OcenaRepozytorium ocenaRepozytorium,
                       IndexRepozytorium indexRepozytorium,
                       DzienRepozytorium dzienRepozytorium) {
        this.ocenaRepozytorium = ocenaRepozytorium;
        this.indexRepozytorium = indexRepozytorium;
        this.dzienRepozytorium = dzienRepozytorium;
    }

    public UtworzOceneOdpowiedz utworzOcene(UtworzOceneZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz response = factory.createUtworzOceneOdpowiedz();

        Ocena ocena = new Ocena();
        ocena.setOcena(req.getOcena());
        ocena.setOpis(req.getOpis());

        try {
            Index index = indexRepozytorium.findOne(req.getIdIndexu());
            Dzien dzien = dzienRepozytorium.findOne(req.getIdDnia());

            ocena.getDzien().add(dzien);
            ocena.setIndex(index);

            ocena = ocenaRepozytorium.save(ocena);

            response.setIdObiektu(ocena.getId());
            response.setWynikWalidacji("Utworzono ocenę o id: " + ocena.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
