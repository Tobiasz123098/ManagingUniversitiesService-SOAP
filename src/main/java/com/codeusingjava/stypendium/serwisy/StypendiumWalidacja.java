package com.codeusingjava.stypendium.serwisy;

import com.sruuniwersytet.DodajStypendiumDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajStypendiumDoStudentaZapytanie;
import org.springframework.stereotype.Service;

import static com.codeusingjava.osiagniecie.serwisy.OsiagniecieWalidator.POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE;

@Service
public class StypendiumWalidacja {

    public static final String POLE_RODZAJ_STYPENDIUM_NIE_MOŻE_BYĆ_PUSTE = "Pole 'rodzaj stypendium' nie może być puste";

    public boolean waliduj(DodajStypendiumDoStudentaZapytanie req, DodajStypendiumDoStudentaOdpowiedz res) {

        if (req.getIdStudenta() == null) {
            res.setWynikWalidacji(POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getRodzajStypendium() == null) {
            res.setWynikWalidacji(POLE_RODZAJ_STYPENDIUM_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
