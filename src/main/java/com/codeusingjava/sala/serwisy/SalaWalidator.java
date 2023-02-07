package com.codeusingjava.sala.serwisy;

import com.sruuniwersytet.DodajSaleDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajSaleDoUniwersytetuZapytanie;
import org.springframework.stereotype.Service;

@Service
public class SalaWalidator {

    public static final String POLE_NUMER_SALI_NIE_MOŻE_BYĆ_PUSTE = "Pole 'numer sali' nie może być puste";
    public static final String POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id uniwersytetu' nie może być puste";

    public boolean waliduj(DodajSaleDoUniwersytetuZapytanie req, DodajSaleDoUniwersytetuOdpowiedz res) {

        if (req.getNumerSali() == null) {
            res.setWynikWalidacji(POLE_NUMER_SALI_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdUniwersytetu() == null) {
            res.setWynikWalidacji(POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }
        return true;
    }
}
