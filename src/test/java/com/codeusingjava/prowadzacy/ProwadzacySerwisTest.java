package com.codeusingjava.prowadzacy;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.prowadzacy.serwisy.ProwadzacySerwis;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class ProwadzacySerwisTest {

    @InjectMocks
    private ProwadzacySerwis prowadzacySerwis;

    @Mock
    private ProwadzacyRepozytorium prowadzacyRepozytorium;

    @Mock
    private UniwersytetRepozytorium uniwersytetRepozytorium;

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_test() {
        //given
        Prowadzacy prowadzacy = new Prowadzacy();
        prowadzacy.setId(1L);
        String msg = "Dodano prowadzącego do uniwersytetu";
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        req.setTytul("PROFESOR");
        //when
        Mockito.when(uniwersytetRepozytorium.getOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(prowadzacyRepozytorium.save(any(Prowadzacy.class))).thenReturn(prowadzacy);
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = prowadzacySerwis.dodajProwadzacegoDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_prowadzacego_do_uniwersytetu_wyjatek_test() {
        //given
        String msg = "Wystąpił błąd: dupa";
        DodajProwadzacegoDoUniwersytetuZapytanie req = new DodajProwadzacegoDoUniwersytetuZapytanie();
        req.setTytul("PROFESOR");
        //when
        Mockito.when(uniwersytetRepozytorium.getOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(prowadzacyRepozytorium.save(any(Prowadzacy.class))).thenThrow(new IllegalStateException("dupa"));
        DodajProwadzacegoDoUniwersytetuOdpowiedz res = prowadzacySerwis.dodajProwadzacegoDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void wyswietl_prowadzacych_test() {
        //given
        List<Prowadzacy> prowadzacy = new ArrayList<>();
        WyswietlProwadzacychZapytanie req = new WyswietlProwadzacychZapytanie();
        req.setIdUniwersytetu(1L);
        //when
        Mockito.when(prowadzacyRepozytorium.findByUniwersytetId(anyLong())).thenReturn(prowadzacy);
        WyswietlProwadzacychOdpowiedz res = prowadzacySerwis.wyswietlProwadzacych(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(prowadzacy, res.getProwadzacy());
    }

    @Test
    void wyswietl_prowadzacych_wyjatek_test() {
        //given
        List<Prowadzacy> prowadzacy = new ArrayList<>();
        WyswietlProwadzacychZapytanie req = new WyswietlProwadzacychZapytanie();
        req.setIdUniwersytetu(1L);
        //when
        Mockito.when(prowadzacyRepozytorium.findByUniwersytetId(anyLong())).thenThrow(new IllegalStateException("dupa"));
        WyswietlProwadzacychOdpowiedz res = prowadzacySerwis.wyswietlProwadzacych(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(prowadzacy, res.getProwadzacy());
    }
}