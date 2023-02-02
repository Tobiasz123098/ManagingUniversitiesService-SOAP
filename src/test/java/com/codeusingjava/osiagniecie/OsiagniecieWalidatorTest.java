package com.codeusingjava.osiagniecie;

import com.codeusingjava.osiagniecie.serwisy.OsiagniecieWalidator;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OsiagniecieWalidatorTest {

    @InjectMocks
    private OsiagniecieWalidator osiagniecieWalidator;

    @Test
    void  dodaj_osiagniecie_do_studenta_bez_id_studenta_test() {
        //given
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajOsiagnieciaDoStudentaOdpowiedz res = factory.createDodajOsiagnieciaDoStudentaOdpowiedz();
        req.setRodzajOsiagniecia("KONKURS");
        req.setOpis("dupa");
        //when
        osiagniecieWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OsiagniecieWalidator.POLE_ID_STUDENTA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_osiagniecie_do_studenta_bez_rodzaju_osiagniecia_test() {
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajOsiagnieciaDoStudentaOdpowiedz res = factory.createDodajOsiagnieciaDoStudentaOdpowiedz();
        req.setIdStudenta(1L);
        req.setOpis("dupa");
        //when
        osiagniecieWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OsiagniecieWalidator.POLE_RODZAJ_OSIAGNIECIA_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_osiagniecie_do_studenta_bez_opisu_test() {
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajOsiagnieciaDoStudentaOdpowiedz res = factory.createDodajOsiagnieciaDoStudentaOdpowiedz();
        req.setRodzajOsiagniecia("KONKURS");
        req.setIdStudenta(1L);
        //when
        osiagniecieWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(OsiagniecieWalidator.POLE_OPIS_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_osiagniecie_do_studenta_wszystko_ustawione_poprawnie() {
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajOsiagnieciaDoStudentaOdpowiedz res = factory.createDodajOsiagnieciaDoStudentaOdpowiedz();
        req.setRodzajOsiagniecia("KONKURS");
        req.setOpis("dupa");
        req.setIdStudenta(1L);
        //when
        osiagniecieWalidator.waliduj(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(null, res.getWynikWalidacji());
    }
}