package com.codeusingjava.uniwersytet;

import com.codeusingjava.przedmiot.serwisy.PrzedmiotWalidator;
import com.codeusingjava.uniwersytet.serwisy.UniwersytetWalidator;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzUniwersytetOdpowiedz;
import com.sruuniwersytet.UtworzUniwersytetZapytanie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UniwersytetWalidatorTest {

    @InjectMocks
    private UniwersytetWalidator uniwersytetWalidator;

    @Test
    void utworz_uniwersytet_bez_nazwy_test() {
        //given
        UtworzUniwersytetZapytanie req = new UtworzUniwersytetZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzUniwersytetOdpowiedz res = factory.createUtworzUniwersytetOdpowiedz();
        //when
        uniwersytetWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PrzedmiotWalidator.POLE_NAZWA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_uniwersytet_wszystko_ustawione_poprawnie_test() {
        //given
        UtworzUniwersytetZapytanie req = new UtworzUniwersytetZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzUniwersytetOdpowiedz res = factory.createUtworzUniwersytetOdpowiedz();
        req.setNazwa("nazwa");
        //when
        uniwersytetWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }
}