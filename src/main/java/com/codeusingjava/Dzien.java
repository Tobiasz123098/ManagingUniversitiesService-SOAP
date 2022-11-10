package com.codeusingjava;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "dzien")
public class Dzien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_zajec_id", referencedColumnName = "id")
    private PlanZajec planZajec;

    // https://chrysanthium.com/date-time-hibernate-postgres
    private LocalDate odKiedySaZajecia; // 2022-03-13 DATE TIMESTAMP
    private LocalDate doKiedySaZajecia; // ***dniowo nie godzinowo***
//    private LocalTime odKtorejGodziny; // 14:38:01 INTERVAL
//    private Duration ileCzasuTrwajaZajecia; // 00:15:00 INTERVAL
//    private LocalDateTime fdsdsadsa; // 2022-03-13 14:34:15 TIMESTAMP


    @ManyToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;

    public PlanZajec getPlanZajec() {
        return planZajec;
    }

    public void setPlanZajec(PlanZajec planZajec) {
        this.planZajec = planZajec;
    }


    public Long getId() {
        return id;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    public LocalDate getOdKiedySaZajecia() {
        return odKiedySaZajecia;
    }

    public void setOdKiedySaZajecia(LocalDate odKiedySaZajecia) {
        this.odKiedySaZajecia = odKiedySaZajecia;
    }

    public LocalDate getDoKiedySaZajecia() {
        return doKiedySaZajecia;
    }

    public void setDoKiedySaZajecia(LocalDate doKiedySaZajecia) {
        this.doKiedySaZajecia = doKiedySaZajecia;
    }
}