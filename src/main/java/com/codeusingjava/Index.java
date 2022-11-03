package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "index")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Enum KierunekStudiow;
//    private List<Przedmiot> list_przedmiot;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods
}
