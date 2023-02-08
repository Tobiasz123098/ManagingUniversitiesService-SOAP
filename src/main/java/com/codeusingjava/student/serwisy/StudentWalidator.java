package com.codeusingjava.student.serwisy;

import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentaPoIdException;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentowException;
import com.sruuniwersytet.*;
import org.springframework.stereotype.Service;

import static com.codeusingjava.prowadzacy.serwisy.ProwadzacyWalidator.*;

@Service
public class StudentWalidator {

    public static final String POLE_NUMER_INDEXU_NIE_MOŻE_BYĆ_PUSTE = "Pole 'numer indexu' nie może być puste";
    public static final String POLE_KIERUNEK_STUDIÓW_NIE_MOŻE_BYĆ_PUSTE = "Pole 'kierunek studiów' nie może być puste";

    public boolean walidujDodajStudentaDoUniwersytetu(DodajStudentaDoUniwersytetuZapytanie req, DodajStudentaDoUniwersytetuOdpowiedz res) {

        if (req.getImie() == null) {
            res.setWynikWalidacji(POLE_IMIE_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getNazwisko() == null) {
            res.setWynikWalidacji(POLE_NAZWISKO_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getEmail() == null) {
            res.setWynikWalidacji(POLE_EMAIL_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdUniwersytetu() == null) {
            res.setWynikWalidacji(POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getNumerIndexu() == null) {
            res.setWynikWalidacji(POLE_NUMER_INDEXU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getKierunekStudiow() == null) {
            res.setWynikWalidacji(POLE_KIERUNEK_STUDIÓW_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }

    public boolean walidujWyswietlStudentow(WyswietlStudentowZapytanie req) {

        if (req.getIdUniwersytetu() == null) {
            throw new NieMoznaWyswietlicStudentowException("Nie można znaleźć żadnych studentów");
        }

        return true;
    }

    public boolean walidujWyswietlStudentaPoId(WyswietlStudentaPoIdZapytanie req) {

        if (req.getIdStudenta() == null) {
            throw new NieMoznaWyswietlicStudentaPoIdException("Nie można znaleźć żadnego studenta po id");
        }

        return true;
    }
}
