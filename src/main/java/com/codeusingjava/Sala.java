package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "sale")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;
    private int numerSali;

    public Uniwersytet getUniwersytet() {
        return uniwersytet;
    }

    public void setUniwersytet(Uniwersytet uniwersytet) {
        this.uniwersytet = uniwersytet;
    }


    public Long getId() {
        return id;
    }

    public int getNumerSali() {
        return numerSali;
    }

    public void setNumerSali(int numerSali) {
        this.numerSali = numerSali;
    }
}