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

    @ManyToMany(mappedBy = "przedmiot")
    private List<Grupa> grupa;

    @OneToOne
    @JoinColumn(name = "prowadzacy_id", referencedColumnName = "id")
    private Prowadzacy prowadzacy;

    @OneToMany(mappedBy = "przedmiot")
    private List<Ocena> ocena;

    public Prowadzacy getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }


    public Long getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Ocena> getOcena() {
        return ocena;
    }

    public void setOcena(List<Ocena> ocena) {
        this.ocena = ocena;
    }

    public List<Grupa> getGrupa() {
        return grupa;
    }

    public void setGrupa(List<Grupa> grupa) {
        this.grupa = grupa;
    }
}