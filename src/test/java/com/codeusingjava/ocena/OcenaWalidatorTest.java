package com.codeusingjava.ocena;

import com.codeusingjava.ocena.serwisy.OcenaWalidator;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzOceneOdpowiedz;
import com.sruuniwersytet.UtworzOceneZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OcenaWalidatorTest {

    @InjectMocks
    private OcenaWalidator ocenaWalidator;

    @Test
    void utworz_ocene_bez_oceny() {
        //given
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz res = factory.createUtworzOceneOdpowiedz();
        req.setOpis("dupa");
        req.setIdIndexu(1L);
        req.setIdDnia(2L);
        //then
        ocenaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OcenaWalidator.POLE_OCENA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_ocene_bez_id_dnia() {
        //given
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz res = factory.createUtworzOceneOdpowiedz();
        req.setIdIndexu(1L);
        req.setOpis("dupa");
        req.setOcena(5);
        //when
        ocenaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OcenaWalidator.POLE_ID_DNIA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_ocene_bez_id_indexu() {
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz res = factory.createUtworzOceneOdpowiedz();
        req.setOcena(4);
        req.setOpis("dupa");
        req.setIdDnia(1L);
        //when
        ocenaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OcenaWalidator.POLE_ID_INDEXU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_ocene_bez_opisu() {
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz res = factory.createUtworzOceneOdpowiedz();
        req.setIdDnia(1L);
        req.setIdIndexu(2L);
        req.setOcena(3);
        //when
        ocenaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OcenaWalidator.POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_ocene_wszystko_ustawione_poprawnie() {
        UtworzOceneZapytanie req = new UtworzOceneZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzOceneOdpowiedz res = factory.createUtworzOceneOdpowiedz();
        req.setIdDnia(1L);
        req.setIdIndexu(2L);
        req.setOcena(5);
        req.setOpis("dupa");
        //when
        ocenaWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(null, res.getWynikWalidacji());
    }
}