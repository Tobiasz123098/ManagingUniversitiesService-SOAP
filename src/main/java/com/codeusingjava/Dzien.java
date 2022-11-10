package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "dzien")
public class Dzien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_zajec_id", referencedColumnName = "id")
    private PlanZajec planZajec;

    private LocalDate odKiedySaZajecia; // 2022-03-13 DATE TIMESTAMP
    private LocalDate doKiedySaZajecia; // ***dniowo nie godzinowo***

// https://chrysanthium.com/date-time-hibernate-postgres
//    private LocalTime odKtorejGodziny; // 14:38:01 INTERVAL
//    private Duration ileCzasuTrwajaZajecia; // 00:15:00 INTERVAL
//    private LocalDateTime fdsdsadsa; // 2022-03-13 14:34:15 TIMESTAMP


    @ManyToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;

}