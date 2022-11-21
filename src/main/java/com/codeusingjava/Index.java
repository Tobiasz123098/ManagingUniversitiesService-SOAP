package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "index")
public class Index {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "index_id_gen"
    )
    @SequenceGenerator(
            name = "index_id_gen",
            sequenceName = "index_id_seq",
            allocationSize = 1
    )
    private Long id;
    @ManyToOne
    @JoinColumn(name = "grupa_id", referencedColumnName = "id")
    private Grupa grupa;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @OneToMany(mappedBy = "index")
    private List<Ocena> oceny;

    @Enumerated(value = EnumType.STRING)
    private KierunekStudiow kierunekStudiow;

}
