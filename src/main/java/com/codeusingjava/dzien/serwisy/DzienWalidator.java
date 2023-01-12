package com.codeusingjava.dzien.serwisy;

import com.sruuniwersytet.UtworzDzienOdpowiedz;
import com.sruuniwersytet.UtworzDzienZapytanie;
import org.springframework.stereotype.Service;

@Service
public class DzienWalidator {

    public static final String POLE_DATA_DNIA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'data dnia' nie może być puste";
    public static final String POLE_OD_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'od kiedy zajęcia' nie może być puste";
    public static final String POLE_DO_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'do kiedy zajęcia' nie może być puste";

    public boolean waliduj(UtworzDzienZapytanie req, UtworzDzienOdpowiedz response) {

        if (req.getDataDnia() == null) {
            response.setWynikWalidacji(POLE_DATA_DNIA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getOdKiedyZajecia() == null) {
            response.setWynikWalidacji(POLE_OD_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getDoKiedyZajecia() == null) {
            response.setWynikWalidacji(POLE_DO_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
