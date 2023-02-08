package com.codeusingjava.student;

import com.codeusingjava.prowadzacy.serwisy.ProwadzacyWalidator;
import com.codeusingjava.student.serwisy.StudentWalidator;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentaPoIdException;
import com.codeusingjava.student.wyjatki.NieMoznaWyswietlicStudentowException;
import com.sruuniwersytet.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentWalidatorTest {

    @InjectMocks
    private StudentWalidator studentWalidator;

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_imienia_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setNazwisko("nazwisko");
        req.setEmail("email");
        req.setIdUniwersytetu(1L);
        req.setNumerIndexu("123ABC");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_IMIE_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_nazwiska_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setImie("imie");
        req.setEmail("email");
        req.setIdUniwersytetu(1L);
        req.setNumerIndexu("123ABC");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_NAZWISKO_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());

    }

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_emailu_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setNazwisko("nazwisko");
        req.setImie("imie");
        req.setIdUniwersytetu(1L);
        req.setNumerIndexu("123ABC");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_EMAIL_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_id_uniwersytetu_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setNazwisko("nazwisko");
        req.setEmail("email");
        req.setImie("imie");
        req.setNumerIndexu("123ABC");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(ProwadzacyWalidator.POLE_ID_UNIWERSYTETU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_numeru_indexu_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setNazwisko("nazwisko");
        req.setEmail("email");
        req.setIdUniwersytetu(1L);
        req.setImie("imie");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(StudentWalidator.POLE_NUMER_INDEXU_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_bez_kierunku_studiow_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setNazwisko("nazwisko");
        req.setEmail("email");
        req.setIdUniwersytetu(1L);
        req.setNumerIndexu("123ABC");
        req.setImie("imie");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(StudentWalidator.POLE_KIERUNEK_STUDIÓW_NIE_MOŻE_BYĆ_PUSTE, res.getWynikWalidacji());
    }

    @Test
    void dodaj_studenta_do_uniwersytetu_wszystko_ustawione_poprawnie_test() {
        //given
        DodajStudentaDoUniwersytetuZapytanie req = new DodajStudentaDoUniwersytetuZapytanie();
        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz res = factory.createDodajStudentaDoUniwersytetuOdpowiedz();
        req.setImie("imie");
        req.setNazwisko("nazwisko");
        req.setEmail("email");
        req.setIdUniwersytetu(1L);
        req.setNumerIndexu("123ABC");
        req.setKierunekStudiow("ADMINISTRACJA");
        //when
        studentWalidator.walidujDodajStudentaDoUniwersytetu(req, res);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertNull(res.getWynikWalidacji());
    }

    @Test
    void wyswietl_studentow_bez_id_uniwersytetu_test() {
        //given
        WyswietlStudentowZapytanie req = new WyswietlStudentowZapytanie();
        //when
        Exception exception = assertThrows(NieMoznaWyswietlicStudentowException.class, () -> studentWalidator.walidujWyswietlStudentow(req));
        //then
        String expectedMessage = "Nie można znaleźć żadnych studentów";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void wyswietl_studentow_wszystko_ustawione_poprawnie_test() {
        //given
        WyswietlStudentowZapytanie req = new WyswietlStudentowZapytanie();
        req.setIdUniwersytetu(1L);
        //then
        Assertions.assertTrue(studentWalidator.walidujWyswietlStudentow(req));
    }

    @Test
    void wyswietl_studentow_po_id_bez_id_uniwersytetu_test() {
        //given
        WyswietlStudentaPoIdZapytanie req = new WyswietlStudentaPoIdZapytanie();
        //when
        Exception exception = assertThrows(NieMoznaWyswietlicStudentaPoIdException.class, () -> studentWalidator.walidujWyswietlStudentaPoId(req));
        //then
        String expectedMessage = "Nie można znaleźć żadnego studenta po id";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void wyswietl_studentow_po_id_wszystko_ustawione_poprawnie_test() {
        //given
        WyswietlStudentaPoIdZapytanie req = new WyswietlStudentaPoIdZapytanie();
        req.setIdStudenta(1L);
        //then
        Assertions.assertTrue(studentWalidator.walidujWyswietlStudentaPoId(req));
    }
}