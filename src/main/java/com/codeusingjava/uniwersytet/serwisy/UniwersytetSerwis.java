package com.codeusingjava.uniwersytet.serwisy;

import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzUniwersytetOdpowiedz;
import com.sruuniwersytet.UtworzUniwersytetZapytanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniwersytetSerwis {

    private final UniwersytetRepozytorium uniwersytetRepozytorium;

    @Autowired
    public UniwersytetSerwis(UniwersytetRepozytorium uniwersytetRepozytorium) {
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
    }

    public UtworzUniwersytetOdpowiedz utworzUniwersytet(UtworzUniwersytetZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzUniwersytetOdpowiedz response = factory.createUtworzUniwersytetOdpowiedz();

        Uniwersytet uniwersytet = new Uniwersytet();
        uniwersytet.setNazwa(req.getNazwa());

        try {
            uniwersytet = uniwersytetRepozytorium.save(uniwersytet);
            response.setIdObiektu(uniwersytet.getId());
            response.setWynikWalidacji("Utworzono uniwersytet o id: " + uniwersytet.getId());
        } catch (Exception e) {
            response.setWynikWalidacji("Wystąpił błąd: " + e.getMessage());
        }

        return response;
    }
}
