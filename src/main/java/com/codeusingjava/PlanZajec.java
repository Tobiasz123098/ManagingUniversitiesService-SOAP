package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "planZajec")
public class PlanZajec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long odCzas;
    private Long doCzas;
    @OneToMany(mappedBy = "planZajec")
    List<Dzien> dzien;


    public Long getId() {
        return id;
    }

    public Long getOdCzas() {
        return odCzas;
    }

    public void setOdCzas(Long odCzas) {
        this.odCzas = odCzas;
    }

    public Long getDoCzas() {
        return doCzas;
    }

    public void setDoCzas(Long doCzas) {
        this.doCzas = doCzas;
    }

    public List<Dzien> getDzien() {
        return dzien;
    }

    public void setDzien(List<Dzien> dzien) {
        this.dzien = dzien;
    }
}