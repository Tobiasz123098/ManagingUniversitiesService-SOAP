package com.codeusingjava.student.repozytoria;

import com.codeusingjava.student.domena.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepozytorium extends JpaRepository<Student, Long> {

    List<Student> findByUniwersytetId(Long id);
/*
    Student fgbn();*/

}
