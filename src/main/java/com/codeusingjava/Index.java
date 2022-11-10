package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "index")
public class Index {

    @ManyToOne
    @JoinColumn(name = "grupa_id", referencedColumnName = "id")
    private Grupa grupa;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private Enum KierunekStudiow;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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
