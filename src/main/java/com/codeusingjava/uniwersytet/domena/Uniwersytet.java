package com.codeusingjava.uniwersytet.domena;

import com.codeusingjava.prowadzacy.domena.Prowadzacy;
import com.codeusingjava.sala.domena.Sala;
import com.codeusingjava.student.domena.Student;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    private List<Student> studenci = new ArrayList<>();

    @OneToMany(mappedBy = "uniwersytet")
    private List<Sala> sale = new ArrayList<>();

    @OneToMany(mappedBy = "uniwersytet")
    private List<Prowadzacy> prowadzacy = new ArrayList<>();

    public void dodajProwadzacego(Prowadzacy prowadzacy) {
        this.getProwadzacy().add(prowadzacy);
        prowadzacy.setUniwersytet(this);
    }

    public void dodajSale(Sala sala) {
        this.getSale().add(sala);
        sala.setUniwersytet(this);
    }

    public void dodajStudenta(Student student) {
        this.getStudenci().add(student);
        student.setUniwersytet(this);
    }

}