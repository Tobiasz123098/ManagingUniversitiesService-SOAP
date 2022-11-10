package com.codeusingjava;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

}