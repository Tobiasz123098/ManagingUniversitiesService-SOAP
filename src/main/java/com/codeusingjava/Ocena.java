package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "ocena")
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Przedmiot przedmiot;
    //private Prowadzacy prowadzacy;
    //private int ocena;
    //private String description;

    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}