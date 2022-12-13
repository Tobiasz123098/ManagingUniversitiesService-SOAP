package com.codeusingjava.student.serwisy;

import com.codeusingjava.index.domena.Index;
import com.codeusingjava.index.domena.KierunekStudiow;
import com.codeusingjava.index.repozytoria.IndexRepozytorium;
import com.codeusingjava.student.domena.Student;
import com.codeusingjava.student.repozytoria.StudentRepozytorium;
import com.codeusingjava.uniwersytet.domena.Uniwersytet;
import com.codeusingjava.uniwersytet.repozytoria.UniwersytetRepozytorium;
import com.sruuniwersytet.DodajStudentaDoUniwersytetuOdpowiedz;
import com.sruuniwersytet.DodajStudentaDoUniwersytetuZapytanie;
import com.sruuniwersytet.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class StudentSerwis {

    private final StudentRepozytorium studentRepository;

    private final UniwersytetRepozytorium uniwersytetRepozytorium;

    @Autowired
    public StudentSerwis(StudentRepozytorium studentRepository, UniwersytetRepozytorium uniwersytetRepozytorium, IndexRepozytorium indexRepozytorium)
    {
        this.studentRepository = studentRepository;
        this.uniwersytetRepozytorium = uniwersytetRepozytorium;
    }

    @Transactional
    public DodajStudentaDoUniwersytetuOdpowiedz dodajStudentaDoUniwersytetu(DodajStudentaDoUniwersytetuZapytanie req) {

        ObjectFactory factory = new ObjectFactory();
        DodajStudentaDoUniwersytetuOdpowiedz response = factory.createDodajStudentaDoUniwersytetuOdpowiedz();

        Student student = new Student();
        student.setImie(req.getImie());
        student.setNazwisko(req.getNazwisko());
        student.setEmail(req.getEmail());

        Index index = new Index();
        index.setStudent(student);
        index.setNumerIndexu(req.getNumerIndexu());
        index.setKierunekStudiow(KierunekStudiow.valueOf(req.getKierunekStudiow().toUpperCase()));

        student.setIndex(index);

        try {
            Uniwersytet uniwersytet = uniwersytetRepozytorium.findOne(req.getIdUniwersytetu());
            uniwersytet.dodajStudenta(student);

            student = studentRepository.save(student);
            response.setIdObiektu(student.getId());
            response.setWynikWalidacji("Dodano studenta do uniwersytetu i nadano mu index o nr: " + req.getNumerIndexu());
        } catch (Exception e) {
            response.setWynikWalidacji(e.getMessage());
        }

        return response;
    }

    /*public OutputSOATest hello(InputSOATest req) {

        String outputString = "Hello " + req.getTest() + "!";

        ObjectFactory factory = new ObjectFactory();
        OutputSOATest response = factory.createOutputSOATest();
        response.setResult(outputString);

        return response;
    }

    @Transactional
    public GetStudentResponse getStudent(GetStudentById req) {

        Student one = studentRepository.getOne(req.getId());

        ObjectFactory factory = new ObjectFactory();
        GetStudentResponse response = factory.createGetStudentResponse();
        response.setEmail(one.getEmail());
        response.setName(one.getImie());
        return response;
    }

    public CreateStudentResponse createStudent(CreateStudentRequest req) {

        ObjectFactory factory = new ObjectFactory();
        CreateStudentResponse response = factory.createCreateStudentResponse();

        Student student = new Student();
        student.setEmail(req.getEmail());
        student.setImie(req.getName());

        response.setResult(Akcje.CREATED.getOpis());
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            response.setResult(Akcje.FAIL.getOpis() + e.getMessage());
        }

        return response;
    }

    public DisplayAllStudentsResponse displayAllStudents() {
        ObjectFactory factory = new ObjectFactory();
        DisplayAllStudentsResponse response = factory.createDisplayAllStudentsResponse();
        List<Student> student = studentRepository.findAll();
        student.stream()
                .map((this::mapToStudent))
                .forEach(studentElement -> response.getStudentList().add(studentElement));

        return response;
    }

    private StudentElement mapToStudent(Student student) {
        StudentElement studentElement = new StudentElement();
        studentElement.setId(student.getId());
        studentElement.setName(student.getImie());
        studentElement.setEmail(student.getEmail());
        return studentElement;
    }

    public DeleteStudentByIdResponse deleteStudentById(DeleteStudentByIdRequest req) {
        ObjectFactory factory = new ObjectFactory();
        DeleteStudentByIdResponse response = factory.createDeleteStudentByIdResponse();

        response.setResult(Akcje.DELETED.getOpis());
        try {
            Student one = studentRepository.getOne(req.getId());
            studentRepository.delete(one);
        } catch (Exception e) {
            response.setResult(Akcje.FAIL.getOpis() + e.getMessage());
        }

        return response;
    }

    public UpdateStudentResponse updateStudent(UpdateStudentRequest req) {
        ObjectFactory factory = new ObjectFactory();
        UpdateStudentResponse response = factory.createUpdateStudentResponse();

        response.setResult(Akcje.EDITED.getOpis());

        Student one = studentRepository.findOne(req.getId());

        if (one != null) {
            one.setEmail(req.getEmail());
            one.setImie(req.getName());
            studentRepository.saveAndFlush(one);
        } else {
            response.setResult(Akcje.NOT_FOUND.getOpis());
        }
        return response;
    }*/


}







/* numerIndexu
    private void dodajStudentaDoUniwersytetu() {
        Student student = new Student();
        Index index = new Index();
        index.setNumerIndexu("asdfdsg");   to jest właśnie numerIndexu, który dodajemy podczas dodawania studenta do uniwersytetu -- dlatego tez w klasie Student przy encji Index nalezy dodac kaskade @OneToOne(cascade = CascadeType.PERSIST), dzięki niej przy utworzeniu (dodaniu studenta do uniwersytetu) od razu zapisuje się w bazie indeks, wraz z numerem itd.

        index.setStudent(student);
        student.setIndex(index);


    }*/