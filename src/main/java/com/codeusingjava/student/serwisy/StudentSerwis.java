package com.codeusingjava.student.serwisy;

import com.sruuniwersytet.*;
import org.springframework.data.jpa.repository.Query;

public interface StudentSerwis {

    DodajStudentaDoUniwersytetuOdpowiedz dodajStudentaDoUniwersytetu(DodajStudentaDoUniwersytetuZapytanie req);

    WyswietlStudentowOdpowiedz wyswietlStudentow(WyswietlStudentowZapytanie req);

    WyswietlStudentaPoIdOdpowiedz wyswietlStudentaPoId(WyswietlStudentaPoIdZapytanie req);
}