package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "dzien")
public class Dzien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plan_zajec_id", referencedColumnName = "id")
    private PlanZajec planZajec;
    private Long data;
    @ManyToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;
    private Long odCzas;
    private Long doCzas;

    public PlanZajec getPlanZajec() {
        return planZajec;
    }

    public void setPlanZajec(PlanZajec planZajec) {
        this.planZajec = planZajec;
    }


    public Long getId() {
        return id;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
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
}