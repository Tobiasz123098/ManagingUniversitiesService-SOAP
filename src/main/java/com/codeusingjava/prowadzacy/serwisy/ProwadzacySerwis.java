package com.codeusingjava.prowadzacy.serwisy;

import com.codeusingjava.prowadzacy.wyjatki.NieMoznaWyswietlicProwadzacychException;
import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.prowadzacy.domena.Tytul;
import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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
            prowadzacy = prowadzacyRepozytorium.save(prowadzacy);
            response.setIdObiektu(prowadzacy.getId());
            response.setWynikWalidacji("Dodano prowadzącego do uniwersytetu");
        } catch (Exception e) {
            response.setWynikWalidacji("Wystąpił błąd: " + e.getMessage());
        }
        return response;
    }

    public WyswietlProwadzacychOdpowiedz wyswietlProwadzacych(WyswietlProwadzacychZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        WyswietlProwadzacychOdpowiedz response = factory.createWyswietlProwadzacychOdpowiedz();

        try {
            List<Prowadzacy> prowadzacy = prowadzacyRepozytorium.findByUniwersytetId(req.getIdUniwersytetu());
            prowadzacy.stream()
                    .map((this::mapToProwadzacy))
                    .forEach(prowadzacyElement -> response.getProwadzacy().add(prowadzacyElement));
            return response;

        } catch (Exception e) {
            throw new NieMoznaWyswietlicProwadzacychException("Nie znalezniono prowadzących w uniwersytecie", e);
        }
    }

    private ProwadzacyElement mapToProwadzacy(Prowadzacy prowadzacy) {
        ProwadzacyElement prowadzacyElement = new ProwadzacyElement();
        prowadzacyElement.setId(prowadzacy.getId());
        prowadzacyElement.setName(prowadzacy.getImie());
        prowadzacyElement.setNazwisko(prowadzacy.getNazwisko());
        prowadzacyElement.setEmail(prowadzacy.getEmail());
        prowadzacyElement.setTytul(String.valueOf(prowadzacy.getTytul()));
        return prowadzacyElement;
    }
}