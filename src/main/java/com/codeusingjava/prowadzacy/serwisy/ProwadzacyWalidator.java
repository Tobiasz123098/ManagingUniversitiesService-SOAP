package com.codeusingjava.prowadzacy.serwisy;

import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuZapytanie;
import com.sruuniwersytet.WyswietlProwadzacychOdpowiedz;
import com.sruuniwersytet.WyswietlProwadzacychZapytanie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProwadzacyWalidator {

    public static final String POLE_IMIE_NIE_MOŻE_BYĆ_PUSTE = "Pole 'imie' nie może być puste";
    public static final String POLE_NAZWISKO_NIE_MOŻE_BYĆ_PUSTE = "Pole 'nazwisko' nie może być puste";
    public static final String POLE_EMAIL_NIE_MOŻE_BYĆ_PUSTE = "Pole 'email' nie może być puste";
    public static final String POLE_TYTUŁ_NIE_MOŻE_BYĆ_PUSTE = "Pole 'tytul' nie może być puste";
    public static final String POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE = "Pole 'id uniwersytetu' nie może być puste";

    public boolean waliduj_dodaj_prowadzacego_do_uniwersytetu(DodajProwadzacegoDoUniwersytetuZapytanie req, DodajProwadzacegoDoUniwersytetuOdpowiedz res) {

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

        if (req.getTytul() == null) {
            res.setWynikWalidacji(POLE_TYTUŁ_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        if (req.getIdUniwersytetu() == null) {
            res.setWynikWalidacji(POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }

    public boolean waliduj_wyswietl_prowadzacych(WyswietlProwadzacychZapytanie req, WyswietlProwadzacychOdpowiedz res) {

        if (req.getIdUniwersytetu() == null) {
            log.error(POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE);
            return false;
        }

        return true;
    }
}
