package com.codeusingjava.index;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.serwisy.IndexWalidator;
import com.sruuniwersytet.DodajIndexDoGrupyOdpowiedz;
import com.sruuniwersytet.DodajIndexDoGrupyZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class IndexWalidatorTest {

    @InjectMocks
    private IndexWalidator indexWalidator;

    @Test
    void dodaj_index_do_grupy_bez_id_indexu_test() {
        //given
        Grupa grupa = new Grupa();
        grupa.setId(2L);
        DodajIndexDoGrupyZapytanie req = new DodajIndexDoGrupyZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajIndexDoGrupyOdpowiedz res = factory.createDodajIndexDoGrupyOdpowiedz();
        //when
        indexWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(IndexWalidator.POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_index_do_grupy_bez_id_grupy_test() {
        //given
        DodajIndexDoGrupyZapytanie req = new DodajIndexDoGrupyZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajIndexDoGrupyOdpowiedz res = factory.createDodajIndexDoGrupyOdpowiedz();
        req.setIdIndexu(1L);
        //when
        indexWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(IndexWalidator.POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }
}