package com.codeusingjava.sala;

import com.codeusingjava.sala.domena.Sala;
import com.codeusingjava.sala.repozytoria.SalaRepozytorium;
import com.codeusingjava.sala.serwisy.SalaSerwis;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.DodajSaleDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajSaleDoUniwersytetuZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class SalaSerwisTest {

    @InjectMocks
    private SalaSerwis salaSerwis;

    @Mock
    private UniwersytetRepozytorium uniwersytetRepozytorium;

    @Mock
    private SalaRepozytorium salaRepozytorium;

    @Test
    void dodaj_sale_do_uniwersytetu_test() {
        //given
        Sala sala = new Sala();
        sala.setId(1L);
        String msg = "Dodano salę do uniwersytetu";
        DodajSaleDoUniwersytetuZapytanie req = new DodajSaleDoUniwersytetuZapytanie();
        req.setNumerSali(101);
        req.setIdUniwersytetu(1L);
        //when
        Mockito.when(uniwersytetRepozytorium.findOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(salaRepozytorium.save(any(Sala.class))).thenReturn(sala);
        DodajSaleDoUniwersytetuOdpowiedz res = salaSerwis.dodajSaleDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_sale_do_uniwersytetu_wyjatek_test() {
        //given
        DodajSaleDoUniwersytetuZapytanie req = new DodajSaleDoUniwersytetuZapytanie();
        String msg = "Wystąpił błąd: dupa";
        req.setNumerSali(101);
        req.setIdUniwersytetu(1L);
        //when
        Mockito.when(uniwersytetRepozytorium.findOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(salaRepozytorium.save(any(Sala.class))).thenThrow(new IllegalStateException("dupa"));
        DodajSaleDoUniwersytetuOdpowiedz res = salaSerwis.dodajSaleDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }
}