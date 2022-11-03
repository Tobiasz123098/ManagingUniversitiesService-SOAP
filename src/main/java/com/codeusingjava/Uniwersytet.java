package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uniwersytet")
public class Uniwersytet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Student> list_student;
    //private List<Sal> list_sal;
    //private List<Prowadzacy> list_prowadzacy;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}