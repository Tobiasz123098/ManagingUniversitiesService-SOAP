package com.codeusingjava.student.repozytoria;

import com.codeusingjava.student.domena.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepozytorium extends JpaRepository<Student, Long> {

}
