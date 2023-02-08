package com.codeusingjava.stypendium;

import com.codeusingjava.osiagniecie.serwisy.OsiagniecieWalidator;
import com.codeusingjava.stypendium.serwisy.StypendiumWalidacja;
import com.sruuniwersytet.DodajStypendiumDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajStypendiumDoStudentaZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StypendiumWalidacjaTest {

    @InjectMocks
    private StypendiumWalidacja stypendiumWalidacja;

    @Test
    void dodaj_stypendium_do_studenta_bez_id_studenta_test() {
        //given
        DodajStypendiumDoStudentaZapytanie req = new DodajStypendiumDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStypendiumDoStudentaOdpowiedz res = factory.createDodajStypendiumDoStudentaOdpowiedz();
        req.setRodzajStypendium("REKTORA");
        //when
        stypendiumWalidacja.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OsiagniecieWalidator.POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_stypendium_do_studenta_bez_rodzaju_stypendium_test() {
        //given
        DodajStypendiumDoStudentaZapytanie req = new DodajStypendiumDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStypendiumDoStudentaOdpowiedz res = factory.createDodajStypendiumDoStudentaOdpowiedz();
        req.setIdStudenta(1L);
        //when
        stypendiumWalidacja.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(StypendiumWalidacja.POLE_RODZAJ_STYPENDIUM_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_stypendium_do_studenta_wszystko_ustawione_poprawnie() {
        //given
        DodajStypendiumDoStudentaZapytanie req = new DodajStypendiumDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStypendiumDoStudentaOdpowiedz res = factory.createDodajStypendiumDoStudentaOdpowiedz();
        req.setIdStudenta(1L);
        req.setRodzajStypendium("REKTORA");
        //when
        stypendiumWalidacja.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }
}