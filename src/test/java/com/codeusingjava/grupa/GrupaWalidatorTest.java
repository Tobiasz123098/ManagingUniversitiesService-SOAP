package com.codeusingjava.grupa;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.serwisy.GrupaWalidator;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzGrupeOdpowiedz;
import com.sruuniwersytet.UtworzGrupeZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GrupaWalidatorTest {

    @InjectMocks
    private GrupaWalidator grupaWalidator;

    @Test
    void utworz_grupe_bez_nazwy_grupy_test() {
        //given
        UtworzGrupeZapytanie req = new UtworzGrupeZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzGrupeOdpowiedz res = factory.createUtworzGrupeOdpowiedz();
        //when
        grupaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(GrupaWalidator.POLE_NAZWA_GRUPY_NIE_MOŻE_BYC_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_grupe_wszystko_ustawione_poprawnie() {
        //given
        Grupa grupa = new Grupa();
        grupa.setId(1L);
        UtworzGrupeZapytanie req = new UtworzGrupeZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzGrupeOdpowiedz res = factory.createUtworzGrupeOdpowiedz();
        req.setNazwaGrupy("dupa");
        //when
        grupaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(null, res.getWynikWalidacji());
    }
}