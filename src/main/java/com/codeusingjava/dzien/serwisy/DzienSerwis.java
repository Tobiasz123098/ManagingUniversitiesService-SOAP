package com.codeusingjava.dzien.serwisy;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class DzienSerwis {

    private final DzienRepozytorium dzienRepozytorium;

    private final PlanZajecRepozytorium planZajecRepozytorium;

    private final PrzedmiotRepozytorium przedmiotRepozytorium;

    private final DzienWalidator dzienWalidator;

    @Autowired
    public DzienSerwis(DzienRepozytorium dzienRepozytorium,
                       PlanZajecRepozytorium planZajecRepozytorium,
                       PrzedmiotRepozytorium przedmiotRepozytorium,
                       DzienWalidator dzienWalidator) {
        this.dzienRepozytorium = dzienRepozytorium;
        this.planZajecRepozytorium = planZajecRepozytorium;
        this.przedmiotRepozytorium = przedmiotRepozytorium;
        this.dzienWalidator = dzienWalidator;
    }

    public UtworzDzienOdpowiedz utworzDzien(UtworzDzienZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        UtworzDzienOdpowiedz response = factory.createUtworzDzienOdpowiedz();

        if (!dzienWalidator.waliduj(req, response)) {
            return response;
        }

            Dzien dzien = new Dzien();

            LocalDate dataDnia = LocalDate.from(req.getDataDnia().toGregorianCalendar().toZonedDateTime()
                    .withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime());

            LocalDateTime odKiedyZajecia = req.getOdKiedyZajecia().toGregorianCalendar().toZonedDateTime()
                    .toLocalDateTime();

            LocalDateTime doKiedyZajecia = req.getDoKiedyZajecia().toGregorianCalendar().toZonedDateTime()
                    .toLocalDateTime();

            dzien.setDataDnia(dataDnia);
            dzien.setOdKiedyZajecia(LocalTime.from(odKiedyZajecia));
            dzien.setDoKiedyZajecia(LocalTime.from(doKiedyZajecia));

        try {
            Przedmiot przedmiot = przedmiotRepozytorium.findOne(req.getIdPrzedmiotu());
            dzien.setPrzedmiot(przedmiot);
            dzien = dzienRepozytorium.save(dzien);

            response.setIdObiektu(dzien.getId());
            response.setWynikWalidacji("Utworzono dzien o id: " + dzien.getId());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }

    @Transactional
    public DodajDzienDoPlanuZajecOdpowiedz dodajDzienDoPlanuZajec(DodajDzienDoPlanuZajecZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajDzienDoPlanuZajecOdpowiedz response = factory.createDodajDzienDoPlanuZajecOdpowiedz();

        try {
            Dzien dzien = dzienRepozytorium.findOne(req.getIdDnia());
            PlanZajec planZajec = planZajecRepozytorium.findOne(req.getIdPlanuZajec());

            planZajec.dodajDzien(dzien);
            dzien.setPlanZajec(planZajec);

            dzien = dzienRepozytorium.save(dzien);

            response.setIdObiektu(dzien.getId());
            response.setWynikWalidacji("Dodano dzień do planu zajęć");
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }
}
