package com.codeusingjava.osiagniecie;

import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import com.codeusingjava.osiagniecie.repozytoria.OsiagniecieRepozytorium;
import com.codeusingjava.osiagniecie.serwisy.OsiagniecieSerwis;
import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaOdpowiedz;
import com.sruuniwersytet.DodajOsiagnieciaDoStudentaZapytanie;
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
public class OsiagniecieSerwisTest {

    @InjectMocks
    private OsiagniecieSerwis osiagniecieSerwis;

    @Mock
    private OsiagniecieRepozytorium osiagniecieRepozytorium;

    @Mock
    private StudentRepozytorium studentRepozytorium;

    @Test
    void dodaj_osiagniecie_do_studenta_test() {
        //given
        Osiagniecie osiagniecie = new Osiagniecie();
        osiagniecie.setId(2L);
        String msg = "Dodano osiągnięcie do studenta";
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        req.setRodzajOsiagniecia("KONKURS");
        //when
        Mockito.when(osiagniecieRepozytorium.save(any(Osiagniecie.class))).thenReturn(osiagniecie);
        Mockito.when(studentRepozytorium.findOne(anyLong())).thenReturn(new Student());
        DodajOsiagnieciaDoStudentaOdpowiedz res = osiagniecieSerwis.dodajOsiagnieciaDoStudenta(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals(msg, res.getWynikWalidacji());
    }

    @Test
    void dodaj_osiagniecie_do_studenta_wyjatek_test() {
        //given
        DodajOsiagnieciaDoStudentaZapytanie req = new DodajOsiagnieciaDoStudentaZapytanie();
        req.setRodzajOsiagniecia("KONKURS");
        //when
        Mockito.when(osiagniecieRepozytorium.save(any(Osiagniecie.class))).thenThrow(new IllegalStateException("dupa"));
        Mockito.when(studentRepozytorium.findOne(anyLong())).thenReturn(new Student());
        DodajOsiagnieciaDoStudentaOdpowiedz res = osiagniecieSerwis.dodajOsiagnieciaDoStudenta(req);
        //then
        Assertions.assertNotNull(res);
        Assertions.assertEquals("dupa", res.getWynikWalidacji());
    }
}