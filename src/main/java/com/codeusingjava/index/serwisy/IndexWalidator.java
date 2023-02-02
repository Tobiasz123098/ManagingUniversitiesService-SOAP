package com.codeusingjava.index.serwisy;

import com.sruuniwersytet.DodajIndexDoGrupyOdpowiedz;
import com.sruuniwersytet.DodajIndexDoGrupyZapytanie;
import org.springframework.stereotype.Service;

@Service
public class IndexWalidator {

    public static final String POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id indexu' nie może być puste";
    public static final String POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id grupy' nie może być puste";

    public boolean waliduj(DodajIndexDoGrupyZapytanie req, DodajIndexDoGrupyOdpowiedz res) {

        if (req.getIdIndexu() == null) {
            res.setWynikWalidacji(POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdGrupy() == null) {
            res.setWynikWalidacji(POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
