package com.codeusingjava.grupa.serwisy;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzGrupeOdpowiedz;
import com.sruuniwersytet.UtworzGrupeZapytanie;
import com.sruuniwersytet.UtworzUniwersytetOdpowiedz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GrupaSerwis {

    private final GrupaRepozytorium grupaRepozytorium;

    @Autowired
    public GrupaSerwis(GrupaRepozytorium grupaRepozytorium) {
        this.grupaRepozytorium = grupaRepozytorium;
    }

    public UtworzGrupeOdpowiedz utworzGrupe(UtworzGrupeZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzGrupeOdpowiedz response = factory.createUtworzGrupeOdpowiedz();

        Grupa grupa = new Grupa();
        grupa.setNazwaGrupy(req.getNazwaGrupy());

        try {
            grupa = grupaRepozytorium.save(grupa);

            response.setIdObiektu(grupa.getId());
            response.setWynikWalidacji("Utworzono grupę o id: " + grupa.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
