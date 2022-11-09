package com.codeusingjava;

import javax.persistence.*;

@Entity
@Table(name = "stypendium")
public class Stypendium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;
    private Enum RodzajStypednium;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public Enum getRodzajStypednium() {
        return RodzajStypednium;
    }

    public void setRodzajStypednium(Enum rodzajStypednium) {
        RodzajStypednium = rodzajStypednium;
    }
}