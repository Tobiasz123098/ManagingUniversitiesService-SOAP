package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "osiagniecia")
public class Osiagniecia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String nazwa;
    //Enum RodzajOsiagniecia;
    //private String opis;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}