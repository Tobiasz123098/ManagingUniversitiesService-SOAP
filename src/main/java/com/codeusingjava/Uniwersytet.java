package com.codeusingjava;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "uniwersytet")
public class Uniwersytet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Student> student;

    @OneToMany(mappedBy = "uniwersytet")
    private List<Sala> sal;
    @OneToMany(mappedBy = "uniwersytet")
    private List<Prowadzacy> prowadzacy;


    public Long getId() {
        return id;
    }

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Sala> getSal() {
        return sal;
    }

    public void setSal(List<Sala> sal) {
        this.sal = sal;
    }

    public List<Prowadzacy> getProwadzacy() {
        return prowadzacy;
    }

    public void setProwadzacy(List<Prowadzacy> prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

}