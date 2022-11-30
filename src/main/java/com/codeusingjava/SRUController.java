package com.codeusingjava;

import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/*@Controller*/
public class SRUController {
    @Autowired
    private StudentRepozytorium studentRepo;

    @GetMapping("/path")
    public String listAll(Model model) {
        List<Student> listStudents = studentRepo.findAll();
        model.addAttribute("listStudents", listStudents);

        return "path2";
    }
}
