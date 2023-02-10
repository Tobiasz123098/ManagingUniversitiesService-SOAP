package com.codeusingjava.mapowanie;

import com.codeusingjava.dzien.serwisy.DzienSerwis;
import com.codeusingjava.grupa.serwisy.GrupaSerwis;
import com.codeusingjava.index.serwisy.IndexSerwis;
import com.codeusingjava.ocena.serwisy.OcenaSerwis;
import com.codeusingjava.osiagniecie.serwisy.OsiagniecieSerwis;
import com.codeusingjava.planzajec.serwisy.PlanZajecSerwis;
import com.codeusingjava.prowadzacy.serwisy.ProwadzacySerwis;
import com.codeusingjava.przedmiot.serwisy.PrzedmiotSerwis;
import com.codeusingjava.sala.serwisy.SalaSerwis;
import com.codeusingjava.student.serwisy.StudentSerwis;
import com.codeusingjava.stypendium.serwisy.StypendiumSerwis;
import com.codeusingjava.uniwersytet.serwisy.UniwersytetSerwis;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SRUWSEndpoint {

    private static final String NAMESPACE_URI = "http://sruuniwersytet.com";

    private final UniwersytetSerwis uniwersytetSerwis;
    private final ProwadzacySerwis prowadzacySerwis;

    private final SalaSerwis salaSerwis;

    private final StudentSerwis studentSerwis;

    private final OsiagniecieSerwis osiagniecieSerwis;

    private final StypendiumSerwis stypendiumSerwis;

    private final GrupaSerwis grupaSerwis;

    private final IndexSerwis indexSerwis;

    private final PlanZajecSerwis planZajecSerwis;

    private final DzienSerwis dzienSerwis;

    private final PrzedmiotSerwis przedmiotSerwis;

    private final OcenaSerwis ocenaSerwis;

    @Autowired
    public SRUWSEndpoint(UniwersytetSerwis uniwersytetSerwis,
                         ProwadzacySerwis prowadzacySerwis,
                         SalaSerwis salaSerwis,
                         StudentSerwis studentSerwis,
                         OsiagniecieSerwis osiagniecieSerwis,
                         StypendiumSerwis stypendiumSerwis,
                         GrupaSerwis grupaSerwis,
                         IndexSerwis indexSerwis,
                         PlanZajecSerwis planZajecSerwis,
                         DzienSerwis dzienSerwis,
                         PrzedmiotSerwis przedmiotSerwis,
                         OcenaSerwis ocenaSerwis) {
        this.uniwersytetSerwis = uniwersytetSerwis;
        this.prowadzacySerwis = prowadzacySerwis;
        this.salaSerwis = salaSerwis;
        this.studentSerwis = studentSerwis;
        this.osiagniecieSerwis = osiagniecieSerwis;
        this.stypendiumSerwis = stypendiumSerwis;
        this.grupaSerwis = grupaSerwis;
        this.indexSerwis = indexSerwis;
        this.planZajecSerwis = planZajecSerwis;
        this.dzienSerwis = dzienSerwis;
        this.przedmiotSerwis = przedmiotSerwis;
        this.ocenaSerwis = ocenaSerwis;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzUniwersytetZapytanie")
    @ResponsePayload
    public UtworzUniwersytetOdpowiedz utworzUniwersytet(@RequestPayload UtworzUniwersytetZapytanie req) {
        return uniwersytetSerwis.utworzUniwersytet(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajProwadzacegoDoUniwersytetuZapytanie")
    @ResponsePayload
    public DodajProwadzacegoDoUniwersytetuOdpowiedz dodajProwadzacegoDoUniwersytetu(@RequestPayload DodajProwadzacegoDoUniwersytetuZapytanie req) {
        return prowadzacySerwis.dodajProwadzacegoDoUniwersytetu(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajSaleDoUniwersytetuZapytanie")
    @ResponsePayload
    public DodajSaleDoUniwersytetuOdpowiedz dodajSaleDoUniwersytetu(@RequestPayload DodajSaleDoUniwersytetuZapytanie req) {
        return salaSerwis.dodajSaleDoUniwersytetu(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajStudentaDoUniwersytetuZapytanie")
    @ResponsePayload
    public DodajStudentaDoUniwersytetuOdpowiedz dodajStudentaDoUniwersytetu(@RequestPayload DodajStudentaDoUniwersytetuZapytanie req) {
        try {
            return studentSerwis.dodajStudentaDoUniwersytetu(req);
        } catch (Exception e) {
            System.out.println("Błąd w SRUESEndpoint: " + e.getMessage());
            return new DodajStudentaDoUniwersytetuOdpowiedz();
        }
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajOsiagnieciaDoStudentaZapytanie")
    @ResponsePayload
    public DodajOsiagnieciaDoStudentaOdpowiedz dodajOsiagnieciaDoStudenta(@RequestPayload DodajOsiagnieciaDoStudentaZapytanie req) {
        return osiagniecieSerwis.dodajOsiagnieciaDoStudenta(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajStypendiumDoStudentaZapytanie")
    @ResponsePayload
    public DodajStypendiumDoStudentaOdpowiedz dodajStypendiumDoStudentaOdpowiedz(@RequestPayload DodajStypendiumDoStudentaZapytanie req) {
        return stypendiumSerwis.dodajStypendiumDoStudenta(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzGrupeZapytanie")
    @ResponsePayload
    public UtworzGrupeOdpowiedz utworzGrupe(@RequestPayload UtworzGrupeZapytanie req) {
        return grupaSerwis.utworzGrupe(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajIndexDoGrupyZapytanie")
    @ResponsePayload
    public DodajIndexDoGrupyOdpowiedz dodajIndexDoGrupy(@RequestPayload DodajIndexDoGrupyZapytanie req) {
        return indexSerwis.dodajIndexDoGrupy(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzPlanZajecZapytanie")
    @ResponsePayload
    public UtworzPlanZajecOdpowiedz utworzPlanZajec(@RequestPayload UtworzPlanZajecZapytanie req) {
        return planZajecSerwis.utworzPlanZajec(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "przypiszPlanZajecDoGrupyZapytanie")
    @ResponsePayload
    public PrzypiszPlanZajecDoGrupyOdpowiedz przypiszPlanZajecDoGrupy(@RequestPayload PrzypiszPlanZajecDoGrupyZapytanie req) {
        return planZajecSerwis.przypiszPlanZajecDoGrupy(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzPrzedmiotZapytanie")
    @ResponsePayload
    public UtworzPrzedmiotOdpowiedz utworzPrzedmiot(@RequestPayload UtworzPrzedmiotZapytanie req) {
        return przedmiotSerwis.utworzPrzedmiot(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzDzienZapytanie")
    @ResponsePayload
    public UtworzDzienOdpowiedz utworzDzien(@RequestPayload UtworzDzienZapytanie req) {
        return dzienSerwis.utworzDzien(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "dodajDzienDoPlanuZajecZapytanie")
    @ResponsePayload
    public DodajDzienDoPlanuZajecOdpowiedz dodajDzienDoPlanuZajec(@RequestPayload DodajDzienDoPlanuZajecZapytanie req) {
        return dzienSerwis.dodajDzienDoPlanuZajec(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "utworzOceneZapytanie")
    @ResponsePayload
    public UtworzOceneOdpowiedz utworzOcene(@RequestPayload UtworzOceneZapytanie req) {
        return ocenaSerwis.utworzOcene(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "wyswietlStudentowZapytanie")
    @ResponsePayload
    public WyswietlStudentowOdpowiedz wyswietlStudentow(@RequestPayload WyswietlStudentowZapytanie req) {
        return studentSerwis.wyswietlStudentow(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "wyswietlStudentaPoIdZapytanie")
    @ResponsePayload
    public WyswietlStudentaPoIdOdpowiedz wyswietlStudentaPoId(@RequestPayload WyswietlStudentaPoIdZapytanie req) {
        return studentSerwis.wyswietlStudentaPoId(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "wyswietlProwadzacychZapytanie")
    @ResponsePayload
    public WyswietlProwadzacychOdpowiedz wyswietlProwadzacych(@RequestPayload WyswietlProwadzacychZapytanie req) {
        return prowadzacySerwis.wyswietlProwadzacych(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "wyswietlPlanZajecPoIdZapytanie")
    @ResponsePayload
    public WyswietlPlanZajecPoIdOdpowiedz wyswietlPlanZajecPoId(@RequestPayload WyswietlPlanZajecPoIdZapytanie req) {
        return planZajecSerwis.wyswietlPlanZajecPoId(req);
    }
}