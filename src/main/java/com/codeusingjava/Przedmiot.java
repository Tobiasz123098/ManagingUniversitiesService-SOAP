package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "przedmiot")
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //private String nazwa
    //private Prowadzacy prowadzacy;
    //private List<Ocena> list_ocena;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}