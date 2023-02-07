package com.codeusingjava.przedmiot.serwisy;

import com.sruuniwersytet.UtworzPrzedmiotOdpowiedz;
import com.sruuniwersytet.UtworzPrzedmiotZapytanie;
import org.springframework.stereotype.Service;

@Service
public class PrzedmiotWalidator {

    public static final String POLE_ID_PROWADZĄCEGO_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id prowadzacego' nie może być puste";
    public static final String POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'nazwa' nie może być puste";

    public boolean waliduj(UtworzPrzedmiotZapytanie req, UtworzPrzedmiotOdpowiedz res) {

        if(req.getNazwa() == null) {
            res.setWynikWalidacji(POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if(req.getIdProwadzacego() == null) {
            res.setWynikWalidacji(POLE_ID_PROWADZĄCEGO_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
