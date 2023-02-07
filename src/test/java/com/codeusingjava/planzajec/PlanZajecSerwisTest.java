package com.codeusingjava.planzajec;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.codeusingjava.planzajec.serwisy.PlanZajecSerwis;
import com.codeusingjava.planzajec.wyjatki.NieMoznaWyswietlicPlanuZajecException;
import com.sruuniwersytet.PrzypiszPlanZajecDoGrupyOdpowiedz;
import com.sruuniwersytet.PrzypiszPlanZajecDoGrupyZapytanie;
import com.sruuniwersytet.UtworzPlanZajecOdpowiedz;
import com.sruuniwersytet.UtworzPlanZajecZapytanie;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
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
public class PlanZajecSerwisTest {

    @InjectMocks
    private PlanZajecSerwis planZajecSerwis;

    @Mock
    private PlanZajecRepozytorium planZajecRepozytorium;

    @Mock
    private GrupaRepozytorium grupaRepozytorium;

    @Test
    void utworz_plan_zajec_test() {
        //given
        PlanZajec planZajec = new PlanZajec();
        planZajec.setId(-1L);
        String msg = "Utworzono nowy plan zajęć o id: " + planZajec.getId();
        UtworzPlanZajecZapytanie req = new UtworzPlanZajecZapytanie();
        req.setDzienOd(new XMLGregorianCalendarImpl());
        req.setDzienDo(new XMLGregorianCalendarImpl());
//        when
        Mockito.when(planZajecRepozytorium.save(any(PlanZajec.class))).thenReturn(planZajec);
        UtworzPlanZajecOdpowiedz res = planZajecSerwis.utworzPlanZajec(req);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg ,res.getWynikWalidacji());
    }

    @Test
    void utworz_plan_zajec_wyjatek_test() {
//given
        UtworzPlanZajecZapytanie req = new UtworzPlanZajecZapytanie();
        req.setDzienOd(new XMLGregorianCalendarImpl());
        req.setDzienDo(new XMLGregorianCalendarImpl());
//        when
        Mockito.when(planZajecRepozytorium.save(any(PlanZajec.class))).thenThrow(new IllegalStateException("dupa"));
        UtworzPlanZajecOdpowiedz res = planZajecSerwis.utworzPlanZajec(req);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa" ,res.getWynikWalidacji());
    }

    @Test
    void przypisz_plan_zajec_do_grupy_test() {
        //given
        PlanZajec planZajec = new PlanZajec();
        planZajec.setId(1L);
        Grupa grupa = new Grupa();
        grupa.setId(2L);
        PrzypiszPlanZajecDoGrupyZapytanie req = new PrzypiszPlanZajecDoGrupyZapytanie();
        req.setIdGrupy(1L);
        req.setIdPlanuZajec(2L);
        //when
        Mockito.when(planZajecRepozytorium.findOne(anyLong())).thenReturn(planZajec);
        Mockito.when(grupaRepozytorium.findOne(anyLong())).thenReturn(new Grupa());
        Mockito.when(grupaRepozytorium.save(any(Grupa.class))).thenReturn(grupa);
        PrzypiszPlanZajecDoGrupyOdpowiedz res = planZajecSerwis.przypiszPlanZajecDoGrupy(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("Przypisano plan zajęć o id: " + planZajec.getId() +
                " do grupy o id: " + grupa.getId(), res.getWynikWalidacji());
        Mockito.verify(planZajecRepozytorium, Mockito.times(1)).findOne(anyLong());
    }

    @Test
    void przypisz_plan_zajec_do_grupy_wyjatek_test() {
        //given
        PrzypiszPlanZajecDoGrupyZapytanie req = new PrzypiszPlanZajecDoGrupyZapytanie();
        //when
        Mockito.when(grupaRepozytorium.findOne(anyLong())).thenReturn(new Grupa());
        //then
        Assertions.assertThrows(NieMoznaWyswietlicPlanuZajecException.class, () -> planZajecSerwis.przypiszPlanZajecDoGrupy(req));
    }
}