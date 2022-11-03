package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "sale")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private int numerSali;


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}