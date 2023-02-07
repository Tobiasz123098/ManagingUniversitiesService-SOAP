package com.codeusingjava.sala;

import com.codeusingjava.sala.serwisy.SalaWalidator;
import com.sruuniwersytet.DodajSaleDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajSaleDoUniwersytetuZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SalaWalidatorTest {

    @InjectMocks
    private SalaWalidator salaWalidator;

    @Test
    void dodaj_sale_do_uniwersytetu_bez_numeru_sali_test() {
        //given
        DodajSaleDoUniwersytetuZapytanie req = new DodajSaleDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajSaleDoUniwersytetuOdpowiedz res = factory.createDodajSaleDoUniwersytetuOdpowiedz();
        req.setIdUniwersytetu(1L);
        //when
        salaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(SalaWalidator.POLE_NUMER_SALI_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_sale_do_uniwersytetu_bez_id_uniwersytetu_test() {
        //given
        DodajSaleDoUniwersytetuZapytanie req = new DodajSaleDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajSaleDoUniwersytetuOdpowiedz res = factory.createDodajSaleDoUniwersytetuOdpowiedz();
        req.setNumerSali(101);
        //when
        salaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(SalaWalidator.POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_sale_do_uniwersytetu_wszystko_ustawione_poprawnie() {
        //given
        DodajSaleDoUniwersytetuZapytanie req = new DodajSaleDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajSaleDoUniwersytetuOdpowiedz res = factory.createDodajSaleDoUniwersytetuOdpowiedz();
        req.setIdUniwersytetu(1L);
        req.setNumerSali(101);
        //when
        salaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }
}