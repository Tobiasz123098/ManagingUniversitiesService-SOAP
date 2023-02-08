package com.codeusingjava.stypendium;

import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.codeusingjava.stypendium.domena.Stypendium;
import com.codeusingjava.stypendium.repozytoria.StypendiumRepozytorium;
import com.codeusingjava.stypendium.serwisy.StypendiumSerwis;
import com.sruuniwersytet.DodajStypendiumDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajStypendiumDoStudentaZapytanie;
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
public class StypendiumSerwisTest {

    @InjectMocks
    private StypendiumSerwis stypendiumSerwis;

    @Mock
    private StypendiumRepozytorium stypendiumRepozytorium;

    @Mock
    private StudentRepozytorium studentRepozytorium;

    @Test
    void dodaj_stypendium_do_studenta_test() {
        //given
        Stypendium stypendium = new Stypendium();
        stypendium.setId(1L);
        DodajStypendiumDoStudentaZapytanie req = new DodajStypendiumDoStudentaZapytanie();
        req.setRodzajStypendium("REKTORA");
        String msg = "Dodano stypendium do studenta";
        //when
        Mockito.when(studentRepozytorium.findOne(anyLong())).thenReturn(new Student());
        Mockito.when(stypendiumRepozytorium.save(any(Stypendium.class))).thenReturn(stypendium);
        DodajStypendiumDoStudentaOdpowiedz res = stypendiumSerwis.dodajStypendiumDoStudenta(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_stypendium_do_studenta_wyjatek_test() {
        //given
        DodajStypendiumDoStudentaZapytanie req = new DodajStypendiumDoStudentaZapytanie();
        req.setRodzajStypendium("REKTORA");
        //when
        Mockito.when(studentRepozytorium.findOne(anyLong())).thenReturn(new Student());
        Mockito.when(stypendiumRepozytorium.save(any(Stypendium.class))).thenThrow(new IllegalStateException("dupa"));
        DodajStypendiumDoStudentaOdpowiedz res = stypendiumSerwis.dodajStypendiumDoStudenta(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }
}