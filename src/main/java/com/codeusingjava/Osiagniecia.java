package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "osiagniecia")
public class Osiagniecia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String nazwa;
    //private Rodzaj (enum for example)
    //think about it


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}