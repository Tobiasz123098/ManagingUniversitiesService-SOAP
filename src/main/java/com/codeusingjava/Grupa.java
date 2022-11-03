package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupa")
public class Grupa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    List<Index> list_index;

    public Long getId() {
        return id;
    }

    //add getters, setters and other methods

}