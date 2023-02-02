package com.codeusingjava.prowadzacy;

import com.codeusingjava.prowadzacy.serwisy.ProwadzacyWalidator;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajProwadzacegoDoUniwersytetuZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class ProwadzacyWalidatorTest {

    @InjectMocks
    private ProwadzacyWalidator prowadzacyWalidator;

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_bez_imienia() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setNazwisko("Nazwisko");
        req.setEmail("email@gmail.com");
        req.setTytul("PROFESOR");
        req.setIdUniwersytetu(1L);
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_IMIE_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_bez_nazwiska() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setImie("Imie");
        req.setEmail("email@gmail.com");
        req.setTytul("PROFESOR");
        req.setIdUniwersytetu(1L);
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_NAZWISKO_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_bez_emaila() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setImie("Imie");
        req.setNazwisko("Nazwisko");
        req.setTytul("PROFESOR");
        req.setIdUniwersytetu(1L);
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_EMAIL_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());

    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_bez_tytulu() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setImie("Imie");
        req.setNazwisko("Nazwisko");
        req.setEmail("email@gmail.com");
        req.setIdUniwersytetu(1L);
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_TYTUŁ_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_bez_id_uniwersytetu() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setImie("Imie");
        req.setNazwisko("Nazwisko");
        req.setEmail("email@gmail.com");
        req.setTytul("PROFESOR");
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());

    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_wszystko_ustawione_poprawnie() {
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = factory.createDodajProwadzacegoDoUniwersytetuOdpowiedz();
        req.setImie("Imie");
        req.setNazwisko("Nazwisko");
        req.setEmail("email@gmail.com");
        req.setTytul("PROFESOR");
        req.setIdUniwersytetu(1L);
        //when
        prowadzacyWalidator.waliduj_dodaj_prowadzacego_do_uniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }
}