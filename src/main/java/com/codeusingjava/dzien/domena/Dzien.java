package com.codeusingjava.dzien.domena;

import com.codeusingjava.planzajec.domena.PlanZajec;
import com.codeusingjava.przedmiot.domena.Przedmiot;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name = "dzien")
public class Dzien {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dzien_id_gen"
    )
    @SequenceGenerator(
            name = "dzien_id_gen",
            sequenceName = "dzien_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_zajec_id", referencedColumnName = "id")
    private PlanZajec planZajec;

    private LocalDate dataDnia;

    private LocalTime odKiedyZajecia; // 2022-03-13 DATE TIMESTAMP

    private LocalTime doKiedyZajecia; // ***dniowo nie godzinowo***

    /*

    dzien_planu_zajec (
        id,
        plan_zajec_id,
        dzien_tygodnia [PONIEDZIALEK, WTOREK, itp]
    )

    dzien_x_przedmiot (
        dzien_id,
        przedmiot_id,
        godzina_rozpoczecia,
        godzina_zakonczenia
    )

     */

    @ManyToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;
}



// https://chrysanthium.com/date-time-hibernate-postgres
//    private LocalTime odKtorejGodziny; // 14:38:01 INTERVAL
//    private Duration ileCzasuTrwajaZajecia; // 00:15:00 INTERVAL
//    private LocalDateTime fdsdsadsa; // 2022-03-13 14:34:15 TIMESTAMP
