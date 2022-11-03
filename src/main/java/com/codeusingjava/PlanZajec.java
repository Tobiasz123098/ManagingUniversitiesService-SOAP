package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "planZajec")
public class PlanZajec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Long od;
//    private Long do;
//    List<Dzien> list_dzien;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}