package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "osiagniecie")
public class Osiagniecie {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "osiagniecie_id_gen"
    )
    @SequenceGenerator(
            name = "osiagniecie_id_gen",
            sequenceName = "osiagniecie_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    private String opis;

    @Enumerated(value = EnumType.STRING)
    private RodzajOsiagniecia rodzajOsiagniecia;

}