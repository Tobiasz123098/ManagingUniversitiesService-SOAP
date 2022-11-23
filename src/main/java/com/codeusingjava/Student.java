package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_gen"
    )
    @SequenceGenerator(
            name = "student_id_gen",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;

    private String imie;

    private String nazwisko;

    private String email;

    @OneToMany(mappedBy = "student")
    List<Osiagniecie> osiagniecia;

    @OneToMany(mappedBy = "student")
    List<Stypendium> stypendia;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "index_id", referencedColumnName = "id")
    private Index index;

}