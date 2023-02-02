package com.codeusingjava.grupa.serwisy;

import com.sruuniwersytet.UtworzGrupeOdpowiedz;
import com.sruuniwersytet.UtworzGrupeZapytanie;
import org.springframework.stereotype.Service;

@Service
public class GrupaWalidator {

    public static final String POLE_NAZWA_GRUPY_NIE_MOŻE_BYC_PUSTE = "Pole 'nazwa grupy' nie może być puste";

    public boolean waliduj(UtworzGrupeZapytanie req, UtworzGrupeOdpowiedz response) {

        if (req.getNazwaGrupy() == null) {
            response.setWynikWalidacji(POLE_NAZWA_GRUPY_NIE_MOŻE_BYC_PUSTE);
            return false;
        }

        return true;
    }
}
