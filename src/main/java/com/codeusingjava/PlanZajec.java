package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "plan_zajec")
public class PlanZajec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate czasOd;

    private LocalDate czasDo;

    @OneToMany(mappedBy = "planZajec")
    List<Dzien> dni;

}