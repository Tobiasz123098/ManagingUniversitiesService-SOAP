package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "dzien")
public class Dzien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private Long data;
    //private Przedmiot przedmiot;
    //private Long od;
    //private Long do;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}