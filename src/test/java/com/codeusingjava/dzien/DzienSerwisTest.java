package com.codeusingjava.dzien;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import com.codeusingjava.dzien.serwisy.DzienSerwis;
import com.codeusingjava.dzien.serwisy.DzienWalidator;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import com.sruuniwersytet.UtworzDzienOdpowiedz;
import com.sruuniwersytet.UtworzDzienZapytanie;
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
public class DzienSerwisTest {

    @InjectMocks
    private DzienSerwis dzienSerwis;

    @Mock
    private DzienRepozytorium dzienRepozytorium;

    @Mock
    private PlanZajecRepozytorium planZajecRepozytorium;

    @Mock
    private PrzedmiotRepozytorium przedmiotRepozytorium;

    @Mock
    private DzienWalidator dzienWalidator;

    @Test
    void utworz_dzien_z_nullowymi_datami_test() {
        //given
        Dzien dzien = new Dzien();
        dzien.setId(-1L);
        Przedmiot przedmiot = new Przedmiot();
        przedmiot.setId(-2L);
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        req.setIdPrzedmiotu(przedmiot.getId());
        //when
        Mockito.when(dzienWalidator.waliduj(any(), any())).thenReturn(false);
        UtworzDzienOdpowiedz res = dzienSerwis.utworzDzien(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }
    @Test
    void utworz_dzien_z_datami_test() {
//        given
        Dzien dzien = new Dzien();
        dzien.setId(-1L);
        String msg = "Utworzono dzien o id: " + dzien.getId();
        UtworzDzienZapytanie req = new UtworzDzienZapytanie();
        req.setDataDnia(new XMLGregorianCalendarImpl());
        req.setOdKiedyZajecia(new XMLGregorianCalendarImpl());
        req.setDoKiedyZajecia(new XMLGregorianCalendarImpl());
//        when
        Mockito.when(dzienRepozytorium.save(any(Dzien.class))).thenReturn(dzien);
        Mockito.when(przedmiotRepozytorium.findOne(anyLong())).thenReturn(new Przedmiot());
        Mockito.when(dzienWalidator.waliduj(any(), any())).thenReturn(true);
        UtworzDzienOdpowiedz res = dzienSerwis.utworzDzien(req);
//        then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg ,res.getWynikWalidacji());
    }
}
