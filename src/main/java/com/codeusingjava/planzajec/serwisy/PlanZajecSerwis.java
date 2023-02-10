package com.codeusingjava.planzajec.serwisy;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.dzien.repozytoria.DzienRepozytorium;
import com.codeusingjava.grupa.domena.Grupa;
import com.codeusingjava.grupa.repozytoria.GrupaRepozytorium;
import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.planzajec.repozytoria.PlanZajecRepozytorium;
import com.codeusingjava.planzajec.wyjatki.NieMoznaWyswietlicPlanuZajecException;
import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.prowadzacy.repozytoria.ProwadzacyRepozytorium;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import com.codeusingjava.przedmiot.repozytoria.PrzedmiotRepozytorium;
import com.sruuniwersytet.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PlanZajecSerwis {

    private final PlanZajecRepozytorium planZajecRepozytorium;

    private final GrupaRepozytorium grupaRepozytorium;

    private final DzienRepozytorium dzienRepozytorium;

    private final PrzedmiotRepozytorium przedmiotRepozytorium;

    private final ProwadzacyRepozytorium prowadzacyRepozytorium;

    @Autowired
    public PlanZajecSerwis(PlanZajecRepozytorium planZajecRepozytorium,
                           GrupaRepozytorium grupaRepozytorium,
                           DzienRepozytorium dzienRepozytorium,
                           PrzedmiotRepozytorium przedmiotRepozytorium,
                           ProwadzacyRepozytorium prowadzacyRepozytorium) {
        this.planZajecRepozytorium = planZajecRepozytorium;
        this.grupaRepozytorium = grupaRepozytorium;
        this.dzienRepozytorium = dzienRepozytorium;
        this.przedmiotRepozytorium = przedmiotRepozytorium;
        this.prowadzacyRepozytorium = prowadzacyRepozytorium;
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

            return response;

        } catch (Exception e) {
            throw new NieMoznaWyswietlicPlanuZajecException("Nie znaleziono planu zajęć", e);
        }
    }

    public WyswietlPlanZajecPoIdOdpowiedz wyswietlPlanZajecPoId(WyswietlPlanZajecPoIdZapytanie req) {
        ObjectFactory factory = new ObjectFactory();
        WyswietlPlanZajecPoIdOdpowiedz response = factory.createWyswietlPlanZajecPoIdOdpowiedz();

        try {
            PlanZajec planZajec = planZajecRepozytorium.findOne(req.getIdPlanuZajec());
            response.setId(planZajec.getId());
            response.setDzienOd(localDateToGregorianCalendar((planZajec.getDzienOd())));
            response.setDzienDo(localDateToGregorianCalendar(planZajec.getDzienDo()));

            List<Dzien> dzien = dzienRepozytorium.findByPlanZajecId(req.getIdPlanuZajec());

            //zmienić na rozwiązanie ze slacka : utworzyć mape <LocalDate, List<Dzien>>, przeiterować ją, a następnie dodać coś do mapToDzien, aby działało
            //cel zadania: ma pokazywać 4 x matematyka w 2002-09-25 (zmieniająć godzinę), bo obecnie filtruje dni jedynie zwracając uwagę na datę, na nic innego
            List<Dzien> filteredDays = new ArrayList<>();
            for (Dzien d : dzien) {
                boolean found = false;
                for (Dzien f : filteredDays) {
                    if (d.getDataDnia().equals(f.getDataDnia())) {
                        f.setDataDnia(d.getDataDnia());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    filteredDays.add(d);
                }
            }

            filteredDays.forEach(dzien1 -> {
                response.getDzien().add(mapToDzien(dzien1));
            });

            return response;
        } catch (Exception e) {
            throw new NieMoznaWyswietlicPlanuZajecException("Nie znaleziono planu zajęć", e);
        }
    }

    private DzienElement mapToDzien(Dzien dzien) {
        DzienElement dzienElement = new DzienElement();
        dzienElement.setId(dzien.getId());
        dzienElement.setDataDnia(localDateToGregorianCalendar(dzien.getDataDnia()));
        dzienElement.getPrzedmiot().add(mapToPrzedmiot(dzien.getPrzedmiot()));
        return dzienElement;
    }

    private PrzedmiotElement mapToPrzedmiot(Przedmiot przedmiot) {
        try {
            Dzien dzienRepo = dzienRepozytorium.findOne(przedmiot.getId());
            PrzedmiotElement przedmiotElement = new PrzedmiotElement();
            przedmiotElement.setId(przedmiot.getId());
            przedmiotElement.setNazwa(przedmiot.getNazwa());
            przedmiotElement.setOdKiedyZajecia(localTimeToGregorianCalendar(dzienRepo.getOdKiedyZajecia()));
            przedmiotElement.setDoKiedyZajecia(localTimeToGregorianCalendar(dzienRepo.getDoKiedyZajecia()));
            przedmiotElement.setProwadzacy(mapToProwadzacy(przedmiot.getProwadzacy()));
            return przedmiotElement;
        } catch (Exception e) {
            throw new NieMoznaWyswietlicPlanuZajecException(e);
        }
    }

    private ProwadzacyElement mapToProwadzacy(Prowadzacy prowadzacy) {
        ProwadzacyElement prowadzacyElement = new ProwadzacyElement();
        prowadzacyElement.setId(prowadzacy.getId());
        prowadzacyElement.setName(prowadzacy.getImie());
        prowadzacyElement.setNazwisko(prowadzacy.getNazwisko());
        prowadzacyElement.setEmail(prowadzacy.getEmail());
        prowadzacyElement.setTytul(String.valueOf(prowadzacy.getTytul()));
        return prowadzacyElement;
    }

    private XMLGregorianCalendar localDateToGregorianCalendar(LocalDate localDate) {
        try {
            XMLGregorianCalendar xmlGregorianCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
            return xmlGregorianCalendar;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    private XMLGregorianCalendar localTimeToGregorianCalendar(LocalTime localTime) {
        try {
            XMLGregorianCalendar xmlGregorianCalendar =
                    DatatypeFactory.newInstance().newXMLGregorianCalendar(localTime.toString());
            return xmlGregorianCalendar;
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
