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
    @GeneratedValue(strategy = GenerationType.IDENTITY) //dodać parametr generator do adnotacji @GeneratedValue i całą adnotację @SequenceGenerator, gdzie schema będzie default
    private Long id;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Student> studenci;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Sala> sale;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Prowadzacy> prowadzacy;

}