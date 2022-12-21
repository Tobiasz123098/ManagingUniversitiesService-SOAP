package com.codeusingjava.student.domena;

import com.codeusingjava.index.domena.Index;
import com.codeusingjava.osiagniecie.domena.Osiagniecie;
import com.codeusingjava.stypendium.domena.Stypendium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.sruuniwersytet.StudentElement;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
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
    List<Osiagniecie> osiagniecia = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    List<Stypendium> stypendia = new ArrayList<>();

    @OneToOne(cascade = CascadeType.PERSIST)  //później można dodać customowe adnotacje
    @JoinColumn(name = "index_id", referencedColumnName = "id")
    private Index index;

    public void dodajOsiagniecie(Osiagniecie osiagniecie) {
        this.getOsiagniecia().add(osiagniecie);
        osiagniecie.setStudent(this);
    }

    public void dodajStypendium(Stypendium stypendium) {
        this.getStypendia().add(stypendium);
        stypendium.setStudent(this);
    }
}