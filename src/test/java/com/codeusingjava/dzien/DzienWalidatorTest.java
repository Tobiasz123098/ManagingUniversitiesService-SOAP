package com.codeusingjava.dzien;

import com.codeusingjava.dzien.serwisy.DzienWalidator;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzDzienOdpowiedz;
import com.sruuniwersytet.UtworzDzienZapytanie;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DzienWalidatorTest {

    @InjectMocks
    private DzienWalidator dzienWalidator;

    @Test
    void utworz_dzien_bez_daty_dnia_test() {
//        given
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzDzienOdpowiedz res = factory.createUtworzDzienOdpowiedz();
//        req.setDataDnia(new XMLGregorianCalendarImpl());
        req.setOdKiedyZajecia(new XMLGregorianCalendarImpl());
        req.setDoKiedyZajecia(new XMLGregorianCalendarImpl());
//        when
        dzienWalidator.waliduj(req, res);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(DzienWalidator.POLE_DATA_DNIA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_dzien_bez_od_kiedy_zajecia_test() {
//        given
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzDzienOdpowiedz res = factory.createUtworzDzienOdpowiedz();
        req.setDataDnia(new XMLGregorianCalendarImpl());
//        req.setOdKiedyZajecia(new XMLGregorianCalendarImpl());
        req.setDoKiedyZajecia(new XMLGregorianCalendarImpl());
//        when
        dzienWalidator.waliduj(req, res);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(DzienWalidator.POLE_OD_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_dzien_bez_do_kiedy_zajecia_test() {
        //        given
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzDzienOdpowiedz res = factory.createUtworzDzienOdpowiedz();
        req.setDataDnia(new XMLGregorianCalendarImpl());
        req.setOdKiedyZajecia(new XMLGregorianCalendarImpl());
//        req.setDoKiedyZajecia(new XMLGregorianCalendarImpl());
//        when
        dzienWalidator.waliduj(req, res);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(DzienWalidator.POLE_DO_KIEDY_ZAJĘCIA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_dzien_wszystko_ustawione_poprawnie_test() {
        //        given
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzDzienOdpowiedz res = factory.createUtworzDzienOdpowiedz();
        req.setDataDnia(new XMLGregorianCalendarImpl());
        req.setOdKiedyZajecia(new XMLGregorianCalendarImpl());
        req.setDoKiedyZajecia(new XMLGregorianCalendarImpl());
//        when
        dzienWalidator.waliduj(req, res);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(null, res.getWynikWalidacji());
    }
}
















