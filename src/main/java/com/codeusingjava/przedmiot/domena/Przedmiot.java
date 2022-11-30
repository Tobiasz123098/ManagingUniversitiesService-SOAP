package com.codeusingjava.przedmiot.domena;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "przedmiot")
public class Przedmiot {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "przedmiot_id_gen"
    )
    @SequenceGenerator(
            name = "przedmiot_id_gen",
            sequenceName = "przedmiot_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String nazwa;

    @OneToOne
    @JoinColumn(name = "prowadzacy_id", referencedColumnName = "id")
    private Prowadzacy prowadzacy;

}

/*
    @OneToMany(mappedBy = "przedmiot")
    private List<Ocena> oceny;

   @ManyToMany(mappedBy = "przedmiot")
    private List<Grupa> grupy;
*/