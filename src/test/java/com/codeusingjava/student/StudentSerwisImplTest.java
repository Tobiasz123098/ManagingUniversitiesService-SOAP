package com.codeusingjava.student;

import com.codeusingjava.index.domena.Index;
import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import com.codeusingjava.osiagniecie.domena.RodzajOsiagniecia;
import com.codeusingjava.osiagniecie.repozytoria.OsiagniecieRepozytorium;
import com.codeusingjava.prowadzacy.wyjatki.NieMoznaWyswietlicProwadzacychException;
import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.codeusingjava.student.serwisy.StudentSerwisImpl;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentowException;
import com.codeusingjava.stypendium.domena.RodzajStypendium;
import com.codeusingjava.stypendium.domena.Stypendium;
import com.codeusingjava.stypendium.repozytoria.StypendiumRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class StudentSerwisImplTest {

    @InjectMocks
    private StudentSerwisImpl studentSerwis;

    @Mock
    private UniwersytetRepozytorium uniwersytetRepozytorium;

    @Mock
    private StudentRepozytorium studentRepozytorium;

    @Mock
    private StypendiumRepozytorium stypendiumRepozytorium;

    @Mock
    private OsiagniecieRepozytorium osiagniecieRepozytorium;

    @Test
    void dodaj_studenta_do_uniwersytetu_test() {
        //given
        Student student = new Student();
        student.setId(1L);
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        String msg = "Dodano studenta do uniwersytetu i nadano mu index o nr: " + req.getNumerIndexu();
        req.setKierunekStudiow("IT");
        //when
        Mockito.when(uniwersytetRepozytorium.findOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(studentRepozytorium.save(any(Student.class))).thenReturn(student);
        DodajStudentaDoUniwersytetuOdpowiedz res = studentSerwis.dodajStudentaDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_wyjatek_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        req.setKierunekStudiow("IT");
        //when
        Mockito.when(uniwersytetRepozytorium.findOne(anyLong())).thenReturn(new Uniwersytet());
        Mockito.when(studentRepozytorium.save(any(Student.class))).thenThrow(new IllegalStateException("dupa"));
        DodajStudentaDoUniwersytetuOdpowiedz res = studentSerwis.dodajStudentaDoUniwersytetu(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }

    @Test
    void wyswietl_studentow_test() {
        //given
        WyswietlStudentowZapytanie req = new WyswietlStudentowZapytanie();
        Student student = new Student();
        student.setId(2L);
        student.setImie("imie");
        student.setNazwisko("nazwisko");
        student.setEmail("email");
        //when
        Mockito.when(studentRepozytorium.findByUniwersytetId(anyLong())).thenReturn(Collections.singletonList(student));
        WyswietlStudentowOdpowiedz res = studentSerwis.wyswietlStudentow(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(student.getId(), res.getStudent().get(0).getId());
        Assertions.assertEquals(student.getImie(), res.getStudent().get(0).getName());
        Assertions.assertEquals(student.getNazwisko(), res.getStudent().get(0).getNazwisko());
        Assertions.assertEquals(student.getEmail(), res.getStudent().get(0).getEmail());
    }

    @Test
    void wyswietl_studentow_wyjatek_test() {
        //given
        WyswietlStudentowZapytanie req = new WyswietlStudentowZapytanie();
        //when
        Mockito.when(studentRepozytorium.findByUniwersytetId(anyLong())).thenThrow(new IllegalStateException("dupa"));
        //then
        Assertions.assertThrows(NieMoznaWyswietlicStudentowException.class, () -> studentSerwis.wyswietlStudentow(req));
    }

    @Test
    void wyswietl_studenta_po_id_test() {
        //given
        WyswietlStudentaPoIdZapytanie req = new WyswietlStudentaPoIdZapytanie();
        req.setIdStudenta(2L);

        Student student = new Student();
        List<Stypendium> stypendiumList = new ArrayList<>();
        Stypendium stypendium = new Stypendium();
        stypendium.setId(3L);
        stypendium.setStudent(student);
        stypendium.setRodzajStypendium(RodzajStypendium.valueOf("REKTORA"));
        stypendiumList.add(stypendium);

        List<Osiagniecie> osiagniecieList = new ArrayList<>();
        Osiagniecie osiagniecie = new Osiagniecie();
        osiagniecie.setId(4L);
        osiagniecie.setStudent(student);
        osiagniecie.setOpis("opis");
        osiagniecie.setRodzajOsiagniecia(RodzajOsiagniecia.valueOf("OLIMPIADA"));

        student.setId(2L);
        student.setImie("imie");
        student.setNazwisko("nazwisko");
        student.setEmail("email");
        student.setStypendia(stypendiumList);
        student.setOsiagniecia(osiagniecieList);

        //when
        Mockito.when(studentRepozytorium.findOne(anyLong())).thenReturn(student);
        Mockito.when(stypendiumRepozytorium.findByStudentId(student.getId())).thenReturn(Collections.singletonList(stypendium));
        Mockito.when(osiagniecieRepozytorium.findByStudentId(student.getId())).thenReturn(Collections.singletonList(osiagniecie));
        WyswietlStudentaPoIdOdpowiedz res = studentSerwis.wyswietlStudentaPoId(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(student.getId(), res.getId());
        Assertions.assertEquals(student.getImie(), res.getName());
        Assertions.assertEquals(student.getNazwisko(), res.getNazwisko());
        Assertions.assertEquals(student.getEmail(), res.getEmail());
        Assertions.assertEquals(student.getStypendia().get(0).getId(), res.getStypendium().get(0).getId());
//        Assertions.assertEquals(student.getStypendia().get(0).getStudent(), res);
        Assertions.assertEquals(student.getStypendia().get(0).getRodzajStypendium(), RodzajStypendium.valueOf(res.getStypendium().get(0).getRodzajStypendium()));
        Assertions.assertEquals(student.getOsiagniecia().get(0).getId(), res.getOsiagniecie().get(0).getId());
        Assertions.assertEquals(student.getOsiagniecia().get(0).getOpis(), res.getOsiagniecie().get(0).getOpis());
        Assertions.assertEquals(student.getOsiagniecia().get(0).getRodzajOsiagniecia(), RodzajOsiagniecia.valueOf(res.getOsiagniecie().get(0).getRodzajOsiagniecia()));

    }

    @Test
    void wyswietl_studenta_po_id_wyjatek_test() {

    }
}





















