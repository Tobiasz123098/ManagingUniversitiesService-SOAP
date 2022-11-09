package com.codeusingjava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public GetStudentResponse getStudent(GetStudentById req) {

        Student one = studentRepository.getOne(req.getId());

        ObjectFactory factory = new ObjectFactory();
        GetStudentResponse response = factory.createGetStudentResponse();
        response.setEmail(one.getEmail());
        response.setName(one.getFirstName());
        return response;
    }

    public CreateStudentResponse createStudent(CreateStudentRequest req) {

        ObjectFactory factory = new ObjectFactory();
        CreateStudentResponse response = factory.createCreateStudentResponse();

        Student student = new Student();
        student.setEmail(req.getEmail());
        student.setFirstName(req.getName());

        response.setResult(Actions.CREATED.getActionDescription());
        try {
            studentRepository.save(student);
        } catch (Exception e) {
            response.setResult(Actions.FAIL.getActionDescription() + e.getMessage());
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
        studentElement.setName(student.getFirstName());
        studentElement.setEmail(student.getEmail());
        return studentElement;
    }

    public DeleteStudentByIdResponse deleteStudentById(DeleteStudentByIdRequest req) {
        ObjectFactory factory = new ObjectFactory();
        DeleteStudentByIdResponse response = factory.createDeleteStudentByIdResponse();

        response.setResult(Actions.DELETED.getActionDescription());
        try {
            Student one = studentRepository.getOne(req.getId());
            studentRepository.delete(one);
        } catch (Exception e) {
            response.setResult(Actions.FAIL.getActionDescription() + e.getMessage());
        }

        return response;
    }

    public UpdateStudentResponse updateStudent(UpdateStudentRequest req) {
        ObjectFactory factory = new ObjectFactory();
        UpdateStudentResponse response = factory.createUpdateStudentResponse();

        response.setResult(Actions.EDITED.getActionDescription());

        Student one = studentRepository.findOne(req.getId());

        if (one != null) {
            one.setEmail(req.getEmail());
            one.setFirstName(req.getName());
            studentRepository.saveAndFlush(one);
        } else {
            response.setResult(Actions.NOT_FOUND.getActionDescription());
        }
        return response;
    }
}

