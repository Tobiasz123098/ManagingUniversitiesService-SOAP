package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "uniwersytet")
public class Uniwersytet {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "uniwersytet_id_gen"
    )
    @SequenceGenerator(
            name = "uniwersytet_id_gen",
            sequenceName = "uniwersytet_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String nazwa;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Student> studenci;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Sala> sale;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Prowadzacy> prowadzacy;

    //ewentualnie usunąć listę prowadzących
}