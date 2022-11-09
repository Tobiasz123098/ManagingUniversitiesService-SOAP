package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;

    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(mappedBy = "student")
    List<Osiagniecia> osiagniecia;
    @OneToMany(mappedBy = "student")
    List<Stypendium> stypendia;

    @OneToOne
    @JoinColumn(name = "index_id", referencedColumnName = "id")
    private Index index;

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public Uniwersytet getUniwersytet() {
        return uniwersytet;
    }

    public void setUniwersytet(Uniwersytet uniwersytet) {
        this.uniwersytet = uniwersytet;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Osiagniecia> getOsiagniecia() {
        return osiagniecia;
    }

    public void setOsiagniecia(List<Osiagniecia> osiagniecia) {
        this.osiagniecia = osiagniecia;
    }

    public List<Stypendium> getStypendia() {
        return stypendia;
    }

    public void setStypendia(List<Stypendium> stypendia) {
        this.stypendia = stypendia;
    }

}