package com.codeusingjava.stypendium.domena;

import com.codeusingjava.student.domena.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "stypendium")
public class Stypendium {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stypendium_id_gen"
    )
    @SequenceGenerator(
            name = "stypendium_id_gen",
            sequenceName = "stypendium_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Enumerated(value = EnumType.STRING)
    private RodzajStypendium rodzajStypendium;

}