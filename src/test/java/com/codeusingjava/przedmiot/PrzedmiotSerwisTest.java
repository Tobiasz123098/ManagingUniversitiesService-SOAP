package com.codeusingjava.przedmiot;

import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import com.codeusingjava.przedmiot.serwisy.PrzedmiotSerwis;
import com.sruuniwersytet.UtworzPrzedmiotOdpowiedz;
import com.sruuniwersytet.UtworzPrzedmiotZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PrzedmiotSerwisTest {

    @InjectMocks
    private PrzedmiotSerwis przedmiotSerwis;

    @Mock
    private PrzedmiotRepozytorium przedmiotRepozytorium;

    @Mock
    private ProwadzacyRepozytorium prowadzacyRepozytorium;


    @Test
    void utworz_przedmiot_test() {
        //given
        Przedmiot przedmiot = new Przedmiot();
        przedmiot.setId(1L);
        String msg = "Utworzono przedmiot o id: " + przedmiot.getId();
        UtworzPrzedmiotZapytanie req = new UtworzPrzedmiotZapytanie();
        //when
        Mockito.when(przedmiotRepozytorium.save(any(Przedmiot.class))).thenReturn(przedmiot);
        UtworzPrzedmiotOdpowiedz res = przedmiotSerwis.utworzPrzedmiot(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void utworz_przedmiot_wyjatek_test() {
        //given
        UtworzPrzedmiotZapytanie req = new UtworzPrzedmiotZapytanie();
        //when
        Mockito.when(przedmiotRepozytorium.save(any(Przedmiot.class))).thenThrow(new IllegalStateException("dupa"));
        UtworzPrzedmiotOdpowiedz res = przedmiotSerwis.utworzPrzedmiot(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }
}