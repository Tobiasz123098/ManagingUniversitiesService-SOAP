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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Student> student;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Sala> sal;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Prowadzacy> prowadzacy;

}