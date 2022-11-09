package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "prowadzacy")
public class Prowadzacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uniwersytet_id", referencedColumnName = "id")
    private Uniwersytet uniwersytet;

    @OneToOne
    @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    private Przedmiot przedmiot;
    private String firstName;
    private String lastName;
    private String email;

    public Przedmiot getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(Przedmiot przedmiot) {
        this.przedmiot = przedmiot;
    }

    //private enum Tytul;

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
}