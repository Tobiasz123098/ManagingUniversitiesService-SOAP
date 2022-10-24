package com.codeusingjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public OutputSOATest hello(InputSOATest req) {

        String outputString = "Hello " + req.getTest() + "!";

        ObjectFactory factory = new ObjectFactory();
        OutputSOATest response = factory.createOutputSOATest();
        response.setResult(outputString);

        return response;
    }

    public GetStudentResponse getStudent(GetStudentById req) {

        Student one = studentRepository.getOne(req.getId());

        ObjectFactory factory = new ObjectFactory();
        GetStudentResponse response = factory.createGetStudentResponse();
        response.setId(one.getId());
        response.setEmail(one.getEmail());
        response.setName(one.getName());
        return response;
    }

    public CreateStudentResponse createStudent(CreateStudentRequest req) {

        ObjectFactory factory = new ObjectFactory();
        CreateStudentResponse response = factory.createCreateStudentResponse();

        Student student = new Student();
        student.setEmail(req.getEmail());
        student.setName(req.getName());
        studentRepository.save(student);

        response.setId(student.getId());
        response.setEmail(req.getEmail());
        response.setName(req.getName());

        return response;
    }

    public DisplayAllStudentsResponse displayAllStudents(DisplayAllStudentsRequest req) {
        ObjectFactory factory = new ObjectFactory();
        DisplayAllStudentsResponse response = factory.createDisplayAllStudentsResponse();
        List<Student> student = studentRepository.findAll();
        student.stream()
                .map((student1 -> mapToStudent(student1)))
                .collect(Collectors.toList());



        return response;
    }

    //learn stream
    //understand 2 classes -> displayAllStudents and maptoStudent
    //modify wsdl to display all students (photo in the phone will help) -> maybe add thymeleaf (website tutorial)

    private Student mapToStudent(Student student){
        Student studentEntity = new Student();
        studentEntity.setName(student.getName());
        studentEntity.setEmail(student.getEmail());
        return studentEntity;
    }

    public DeleteStudentByIdResponse deleteStudentById(DeleteStudentByIdRequest req) {
        ObjectFactory factory = new ObjectFactory();
        DeleteStudentByIdResponse response = factory.createDeleteStudentByIdResponse();

        Student one = studentRepository.getOne(req.getId());
        studentRepository.delete(one);
        Student student = new Student();
        response.setId(req.getId());
        response.setEmail(student.getEmail());
        response.setName(student.getName());

        //add the proper response with email and name property
        return response;
    }

    public UpdateStudentResponse updateStudent(UpdateStudentRequest req) {
        ObjectFactory factory = new ObjectFactory();
        UpdateStudentResponse response = factory.createUpdateStudentResponse();

        response.setId(req.getId());
        response.setUpdatedEmail(req.getNewEmail());
        response.setUpdatedName(req.getNewName());

        Student student = new Student();
        student.setId(response.getId());
        student.setEmail(response.getUpdatedEmail());
        student.setName(response.getUpdatedName());
        studentRepository.saveAndFlush(student);

        return response;
    }
}


