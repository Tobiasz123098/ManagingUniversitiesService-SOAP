package com.codeusingjava;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "planZajec")
public class PlanZajec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate odCzas;
    private LocalDate doCzas;
    @OneToMany(mappedBy = "planZajec")
    List<Dzien> dzien;


    public Long getId() {
        return id;
    }

    public LocalDate getOdCzas() {
        return odCzas;
    }

    public void setOdCzas(LocalDate odCzas) {
        this.odCzas = odCzas;
    }

    public LocalDate getDoCzas() {
        return doCzas;
    }

    public void setDoCzas(LocalDate doCzas) {
        this.doCzas = doCzas;
    }

    public List<Dzien> getDzien() {
        return dzien;
    }

    public void setDzien(List<Dzien> dzien) {
        this.dzien = dzien;
    }
}