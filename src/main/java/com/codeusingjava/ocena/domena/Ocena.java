package com.codeusingjava.ocena.domena;

import com.codeusingjava.dzien.domena.Dzien;
import com.codeusingjava.index.domena.Index;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ocena")
public class Ocena {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ocena_id_gen"
    )
    @SequenceGenerator(
            name = "ocena_id_gen",
            sequenceName = "ocena_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "index_id", referencedColumnName = "id")
    private Index index;

    @ManyToMany
    @JoinTable(
            name = "ocena_dzien",
            joinColumns = @JoinColumn(name = "ocena_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "dzien_id", referencedColumnName = "id")
    )
    private List<Dzien> dzien = new ArrayList<>();

    private int ocena;

    private String opis;

}


/*    @ManyToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;*/


/*
    @ManyToOne
    @JoinColumn(name = "prowadzacy_id", referencedColumnName = "id")
    private Prowadzacy prowadzacy;*/