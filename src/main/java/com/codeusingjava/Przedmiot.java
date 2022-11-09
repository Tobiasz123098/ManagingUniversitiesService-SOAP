package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "przedmiot")
public class Przedmiot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nazwa;

    @ManyToOne
    @JoinColumn(name = "index_id", referencedColumnName = "id")
    private Index index;
    @OneToOne
    @JoinColumn(name = "prowadzacy_id", referencedColumnName = "id")
    private Prowadzacy prowadzacy;

    @OneToMany(mappedBy = "przedmiot")
    private List<Ocena> ocena;

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Prowadzacy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }


    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}