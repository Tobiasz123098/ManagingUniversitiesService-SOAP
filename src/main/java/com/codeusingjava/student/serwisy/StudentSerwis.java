package com.codeusingjava.student.serwisy;

import com.sruuniwersytet.DodajStudentaDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajStudentaDoUniwersytetuZapytanie;
import com.sruuniwersytet.WyswietlStudentowOdpowiedz;
import com.sruuniwersytet.WyswietlStudentowZapytanie;

public interface StudentSerwis {

    DodajStudentaDoUniwersytetuOdpowiedz dodajStudentaDoUniwersytetu(DodajStudentaDoUniwersytetuZapytanie req);

    WyswietlStudentowOdpowiedz wyswietlStudentow(WyswietlStudentowZapytanie req);
}