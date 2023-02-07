package com.codeusingjava.przedmiot;

import com.codeusingjava.przedmiot.serwisy.PrzedmiotWalidator;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzPrzedmiotOdpowiedz;
import com.sruuniwersytet.UtworzPrzedmiotZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PrzedmiotWalidatorTest {

    @InjectMocks
    private PrzedmiotWalidator przedmiotWalidator;

    @Test
    void utworz_przedmiot_bez_nazwy_test() {
        //given
        UtworzPrzedmiotZapytanie req = new UtworzPrzedmiotZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPrzedmiotOdpowiedz res= factory.createUtworzPrzedmiotOdpowiedz();
        req.setIdProwadzacego(1L);
        //when
        przedmiotWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PrzedmiotWalidator.POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_przedmiot_bez_id_prowadzacego_test() {
        //given
        UtworzPrzedmiotZapytanie req = new UtworzPrzedmiotZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPrzedmiotOdpowiedz res= factory.createUtworzPrzedmiotOdpowiedz();
        req.setNazwa("nazwa");
        //when
        przedmiotWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PrzedmiotWalidator.POLE_ID_PROWADZĄCEGO_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());

    }

    @Test
    void utworz_przedmiot_wszystkie_pola_ustawione_poprawnie_test() {
        //given
        UtworzPrzedmiotZapytanie req = new UtworzPrzedmiotZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPrzedmiotOdpowiedz res= factory.createUtworzPrzedmiotOdpowiedz();
        req.setIdProwadzacego(1L);
        req.setNazwa("nazwa");
        //when
        przedmiotWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());

    }
}