package com.codeusingjava.planzajec;

import com.codeusingjava.planzajec.serwisy.PlanZajecWalidator;
import com.sruuniwersytet.*;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlanZajecWalidatorTest {

    @InjectMocks
    private PlanZajecWalidator planZajecWalidator;

    @Test
    void utworz_plan_zajec_bez_dzien_od_test() {
        //given
        UtworzPlanZajecZapytanie req = new UtworzPlanZajecZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPlanZajecOdpowiedz res = factory.createUtworzPlanZajecOdpowiedz();
        req.setDzienDo(new XMLGregorianCalendarImpl());
        //when
        planZajecWalidator.waliduj_utworz_plan_zajec(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PlanZajecWalidator.POLE_DZIEN_OD_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_plan_zajec_bez_dzien_do_test() {
        //given
        UtworzPlanZajecZapytanie req = new UtworzPlanZajecZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPlanZajecOdpowiedz res = factory.createUtworzPlanZajecOdpowiedz();
        req.setDzienOd(new XMLGregorianCalendarImpl());
        //when
        planZajecWalidator.waliduj_utworz_plan_zajec(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PlanZajecWalidator.POLE_DZIEN_DO_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void utworz_plan_zajec_wszystko_ustawione_poprawnie_test() {
        //given
        UtworzPlanZajecZapytanie req = new UtworzPlanZajecZapytanie();
        ObjectFactory factory = new ObjectFactory();
        UtworzPlanZajecOdpowiedz res = factory.createUtworzPlanZajecOdpowiedz();
        req.setDzienOd(new XMLGregorianCalendarImpl());
        req.setDzienDo(new XMLGregorianCalendarImpl());
        //when
        planZajecWalidator.waliduj_utworz_plan_zajec(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }

    @Test
    void przypisz_plan_zajec_do_grupy_bez_id_grupy_test() {
        //given
        PrzypiszPlanZajecDoGrupyZapytanie req = new PrzypiszPlanZajecDoGrupyZapytanie();
        ObjectFactory factory = new ObjectFactory();
        PrzypiszPlanZajecDoGrupyOdpowiedz res = factory.createPrzypiszPlanZajecDoGrupyOdpowiedz();
        req.setIdPlanuZajec(1L);
        //when
        planZajecWalidator.waliduj_przypisz_plan_zajec_do_grupy(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PlanZajecWalidator.POLE_ID_GRUPY_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void przypisz_plan_zajec_do_grupy_bez_id_planu_zajec_test() {
        //given
        PrzypiszPlanZajecDoGrupyZapytanie req = new PrzypiszPlanZajecDoGrupyZapytanie();
        ObjectFactory factory = new ObjectFactory();
        PrzypiszPlanZajecDoGrupyOdpowiedz res = factory.createPrzypiszPlanZajecDoGrupyOdpowiedz();
        req.setIdGrupy(1L);
        //when
        planZajecWalidator.waliduj_przypisz_plan_zajec_do_grupy(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(PlanZajecWalidator.POLE_ID_PLANU_ZAJEC_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void przypisz_plan_zajec_do_grupy_wszystko_ustawione_poprawnie_test() {
        //given
        PrzypiszPlanZajecDoGrupyZapytanie req = new PrzypiszPlanZajecDoGrupyZapytanie();
        ObjectFactory factory = new ObjectFactory();
        PrzypiszPlanZajecDoGrupyOdpowiedz res = factory.createPrzypiszPlanZajecDoGrupyOdpowiedz();
        req.setIdGrupy(1L);
        req.setIdPlanuZajec(2L);
        //when
        planZajecWalidator.waliduj_przypisz_plan_zajec_do_grupy(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());

    }
}