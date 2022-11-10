package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupa")
public class Grupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "ilosc_przedmiotow",
            joinColumns = @JoinColumn(name = "grupa_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    )
    List<Przedmiot> przedmiot;

    @OneToMany(mappedBy = "grupa")
    List<Index> index;

    public Long getId() {
        return id;
    }

    public List<Przedmiot> getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(List<Przedmiot> przedmiot) {
        this.przedmiot = przedmiot;
    }

    public List<Index> getIndex() {
        return index;
    }

    public void setIndex(List<Index> index) {
        this.index = index;
    }
}