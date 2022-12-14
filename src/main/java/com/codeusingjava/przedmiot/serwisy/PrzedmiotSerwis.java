package com.codeusingjava.przedmiot.serwisy;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzPrzedmiotOdpowiedz;
import com.sruuniwersytet.UtworzPrzedmiotZapytanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrzedmiotSerwis {

    private final PrzedmiotRepozytorium przedmiotRepozytorium;

    private final ProwadzacyRepozytorium prowadzacyRepozytorium;

    @Autowired
    public PrzedmiotSerwis(PrzedmiotRepozytorium przedmiotRepozytorium,
                           ProwadzacyRepozytorium prowadzacyRepozytorium) {
        this.przedmiotRepozytorium = przedmiotRepozytorium;
        this.prowadzacyRepozytorium = prowadzacyRepozytorium;
    }

    public UtworzPrzedmiotOdpowiedz utworzPrzedmiot(UtworzPrzedmiotZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzPrzedmiotOdpowiedz response = factory.createUtworzPrzedmiotOdpowiedz();

        Przedmiot przedmiot = new Przedmiot();
        przedmiot.setNazwa(req.getNazwa());

        try {
            Prowadzacy prowadzacy = prowadzacyRepozytorium.findOne(req.getIdProwadzacego());
            przedmiot.setProwadzacy(prowadzacy);

            przedmiot = przedmiotRepozytorium.save(przedmiot);

            response.setIdObiektu(przedmiot.getId());
            response.setWynikWalidacji("Utworzono przedmiot o id: " + przedmiot.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
