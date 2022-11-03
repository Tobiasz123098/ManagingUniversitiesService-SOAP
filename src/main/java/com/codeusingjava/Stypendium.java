package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "stypendium")
public class Stypendium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    Enum RodzajStypednium;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}