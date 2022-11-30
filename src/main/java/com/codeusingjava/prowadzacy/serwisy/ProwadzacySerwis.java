package com.codeusingjava.prowadzacy.serwisy;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.prowadzacy.domena.Tytul;
import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProwadzacySerwis {

    private final ProwadzacyRepozytorium prowadzacyRepozytorium;
    private final UniwersytetRepozytorium uniwersytetRepozytorium;


    @Autowired
    public ProwadzacySerwis(ProwadzacyRepozytorium prowadzacyRepozytorium, UniwersytetRepozytorium uniwersytetRepozytorium) {
        this.prowadzacyRepozytorium = prowadzacyRepozytorium;
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
    }

    @Transactional
    public DodajProwadzacegoDoUniwersytetuOdpowiedz dodajProwadzacegoDoUniwersytetu(DodajProwadzacegoDoUniwersytetuZapytanie req) {
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz response = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();

        Prowadzacy prowadzacy = new Prowadzacy();
        prowadzacy.setImie(req.getImie());
        prowadzacy.setNazwisko(req.getNazwisko());
        prowadzacy.setEmail(req.getEmail());
        prowadzacy.setTytul(Tytul.valueOf(req.getTytul().toUpperCase()));


        try {
            Uniwersytet uniwersytet = uniwersytetRepozytorium.getOne(req.getIdUniwersytetu());
            uniwersytet.dodajProwadzacego(prowadzacy);
            response.setIdObiektu(prowadzacy.getId());
            response.setWynikWalidacji("Dodano prowadzącego do uniwersytetu");
        } catch (Exception e) {
            response.setWynikWalidacji("Wystąpił błąd: " + e.getMessage());
        }

        return response;
    }
}
