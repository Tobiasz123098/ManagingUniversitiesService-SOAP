package com.codeusingjava.planzajec.serwisy;

import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.sruuniwersytet.ObjectFactory;
import com.sruuniwersytet.UtworzPlanZajecOdpowiedz;
import com.sruuniwersytet.UtworzPlanZajecZapytanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

@Service
public class PlanZajecSerwis {

    private final PlanZajecRepozytorium planZajecRepozytorium;

    @Autowired
    public PlanZajecSerwis(PlanZajecRepozytorium planZajecRepozytorium) {
        this.planZajecRepozytorium = planZajecRepozytorium;
    }

    public UtworzPlanZajecOdpowiedz utworzPlanZajec(UtworzPlanZajecZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzPlanZajecOdpowiedz response = factory.createUtworzPlanZajecOdpowiedz();

        XMLGregorianCalendar cal1 = req.getDzienOd();
        XMLGregorianCalendar cal2 = req.getDzienDo();

        PlanZajec planZajec = new PlanZajec();

        LocalDate dzienOd = LocalDate.of(
                cal1.getYear(),
                cal1.getMonth(),
                cal1.getDay());
        planZajec.setDzienOd(dzienOd);

        LocalDate dzienDo = LocalDate.of(
                cal2.getYear(),
                cal2.getMonth(),
                cal2.getDay());
        planZajec.setDzienDo(dzienDo);

        try {
            planZajec = planZajecRepozytorium.save(planZajec);

            response.setIdObiektu(planZajec.getId());
            response.setWynikWalidacji("Utworzono nowy plan zajęć o id: " + planZajec.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
