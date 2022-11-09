package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupa")
public class Grupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "grupa")
    List<Index> index;

    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}