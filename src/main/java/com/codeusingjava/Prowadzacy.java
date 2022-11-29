package com.codeusingjava;

import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "prowadzacy")
public class Prowadzacy {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prowadzacy_id_gen"
    )
    @SequenceGenerator(
            name = "prowadzacy_id_gen",
            sequenceName = "prowadzacy_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;

    private String imie;

    private String nazwisko;

    private String email;

    @Enumerated(value = EnumType.STRING)
    private Tytul tytul;


}
