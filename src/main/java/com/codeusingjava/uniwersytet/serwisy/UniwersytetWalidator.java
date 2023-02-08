package com.codeusingjava.uniwersytet.serwisy;

import com.sruuniwersytet.UtworzUniwersytetOdpowiedz;
import com.sruuniwersytet.UtworzUniwersytetZapytanie;
import org.springframework.stereotype.Service;

import static com.codeusingjava.przedmiot.serwisy.PrzedmiotWalidator.POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE;

@Service
public class UniwersytetWalidator {

    public boolean waliduj(UtworzUniwersytetZapytanie req, UtworzUniwersytetOdpowiedz res) {

        if (req.getNazwa() == null) {
            res.setWynikWalidacji(POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
