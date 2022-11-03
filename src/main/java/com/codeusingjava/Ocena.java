package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "ocena")
public class Ocena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //think about it

    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}