package com.codeusingjava.planzajec.serwisy;

import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.ZoneId;

@Service
public class PlanZajecSerwis {

    private final PlanZajecRepozytorium planZajecRepozytorium;

    private final GrupaRepozytorium grupaRepozytorium;

    @Autowired
    public PlanZajecSerwis(PlanZajecRepozytorium planZajecRepozytorium,
                           GrupaRepozytorium grupaRepozytorium) {
        this.planZajecRepozytorium = planZajecRepozytorium;
        this.grupaRepozytorium = grupaRepozytorium;
    }

    public UtworzPlanZajecOdpowiedz utworzPlanZajec(UtworzPlanZajecZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzPlanZajecOdpowiedz response = factory.createUtworzPlanZajecOdpowiedz();

        PlanZajec planZajec = new PlanZajec();

        LocalDate dzienOd = LocalDate.from(req.getDzienOd().toGregorianCalendar().toZonedDateTime()
                .withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());

        LocalDate dzienDo = LocalDate.from(req.getDzienDo().toGregorianCalendar().toZonedDateTime()
                .withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());

        planZajec.setDzienOd(dzienOd);
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

    public PrzypiszPlanZajecDoGrupyOdpowiedz przypiszPlanZajecDoGrupy(PrzypiszPlanZajecDoGrupyZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        PrzypiszPlanZajecDoGrupyOdpowiedz response = factory.createPrzypiszPlanZajecDoGrupyOdpowiedz();

        try {
            PlanZajec planZajec = planZajecRepozytorium.findOne(req.getIdPlanuZajec());
            Grupa grupa = grupaRepozytorium.findOne(req.getIdGrupy());

            grupa.setPlanZajec(planZajec);
            grupa = grupaRepozytorium.save(grupa);

            response.setIdObiektu(grupa.getId());
            response.setWynikWalidacji("Przypisano plan zajęć o id: " + planZajec.getId() +
                    " do grupy o id: " + grupa.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
