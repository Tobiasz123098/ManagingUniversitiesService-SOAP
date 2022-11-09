package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "index")
public class Index {

    @ManyToOne
    @JoinColumn(name = "grupa_id", referencedColumnName = "id")
    private Grupa grupa;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Enum KierunekStudiow;


    @OneToMany(mappedBy = "index")
    private List<Przedmiot> przedmiot;

    public Grupa getGrupa() {
        return grupa;
    }

    public void setGrupa(Grupa grupa) {
        this.grupa = grupa;
    }

    public Long getId() {
        return id;
    }

    //add getters, setters and other methods
}
