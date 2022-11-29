package com.codeusingjava;

import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "sala")
public class Sala {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sala_id_gen"
    )
    @SequenceGenerator(
            name = "sala_id_gen",
            sequenceName = "sala_id_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;

    private int numerSali;

}