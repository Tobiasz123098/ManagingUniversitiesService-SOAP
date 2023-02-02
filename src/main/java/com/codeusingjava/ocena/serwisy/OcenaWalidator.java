package com.codeusingjava.ocena.serwisy;

import com.sruuniwersytet.UtworzOceneOdpowiedz;
import com.sruuniwersytet.UtworzOceneZapytanie;
import org.springframework.stereotype.Service;

@Service
public class OcenaWalidator {

    public static final String POLE_OCENA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'ocena' nie może być puste";
    public static final String POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE = "Pole 'opis' nie może być puste";
    public static final String POLE_ID_DNIA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id dnia' nie może być puste";
    public static final String POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id indexu' nie może być puste";

    public boolean waliduj(UtworzOceneZapytanie req, UtworzOceneOdpowiedz res) {

        if (req.getOcena() == null) {
            res.setWynikWalidacji(POLE_OCENA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getOpis() == null) {
            res.setWynikWalidacji(POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdDnia() == null) {
            res.setWynikWalidacji(POLE_ID_DNIA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdIndexu() == null) {
            res.setWynikWalidacji(POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
