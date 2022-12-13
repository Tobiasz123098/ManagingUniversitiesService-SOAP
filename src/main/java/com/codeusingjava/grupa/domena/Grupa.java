package com.codeusingjava.grupa.domena;

import com.codeusingjava.index.domena.Index;
import com.codeusingjava.planzajec.domena.PlanZajec;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "grupa")
public class Grupa {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "grupa_id_gen"
    )
    @SequenceGenerator(
            name = "grupa_id_gen",
            sequenceName = "grupa_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String nazwaGrupy;

    @OneToOne
    @JoinColumn(name = "plan_zajec_id", referencedColumnName = "id")
    private PlanZajec planZajec;

    @OneToMany(mappedBy = "grupa")
    List<Index> indexy = new ArrayList<>();

    @Modifying
    public void dodajIndex(Index index) {
        this.getIndexy().add(index);
        index.setGrupa(this);
    }
}


/*    @ManyToMany
    @JoinTable(
            name = "ilosc_przedmiotow",
            joinColumns = @JoinColumn(name = "grupa_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "przedmiot_id", referencedColumnName = "id")
    )
    List<Przedmiot> przedmioty; */
