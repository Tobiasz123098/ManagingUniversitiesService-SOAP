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
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "plan_zajec_id_gen"
    )
    @SequenceGenerator(
            name = "plan_zajec_id_gen",
            sequenceName = "plan_zajec_id_seq",
            allocationSize = 1
    )
    private Long id;

    private LocalDate dzienOd;

    private LocalDate dzienDo;

    @OneToMany(mappedBy = "planZajec")
    List<Dzien> dni;

}