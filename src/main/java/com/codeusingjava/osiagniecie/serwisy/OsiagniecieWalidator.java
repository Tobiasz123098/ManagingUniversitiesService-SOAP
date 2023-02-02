package com.codeusingjava.osiagniecie.serwisy;

import com.sruuniwersytet.DodajOsiagnieciaDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaZapytanie;
import org.springframework.stereotype.Service;

@Service
public class OsiagniecieWalidator {

    public static final String POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id studenta' nie może być puste";
    public static final String POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE = "Pole 'opis' nie może być puste";
    public static final String POLE_RODZAJ_OSIAGNIECIA_NIE_MOŻE_BYĆ_PUSTE = "Pole 'rodzaj osiagniecia' nie może być puste";

    public boolean waliduj(DodajOsiagnieciaDoStudentaZapytanie req, DodajOsiagnieciaDoStudentaOdpowiedz res) {

        if (req.getIdStudenta() == null) {
            res.setWynikWalidacji(POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getOpis() == null) {
            res.setWynikWalidacji(POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getRodzajOsiagniecia() == null) {
            res.setWynikWalidacji(POLE_RODZAJ_OSIAGNIECIA_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
