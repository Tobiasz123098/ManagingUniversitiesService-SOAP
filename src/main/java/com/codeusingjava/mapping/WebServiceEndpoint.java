package com.codeusingjava.mapping;

import com.codeusingjava.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WebServiceEndpoint {
    private static final String NAMESPACE_URI = "http://codeusingjava.com";

    private final StudentService studentService;

    @Autowired
    public WebServiceEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "inputSOATest")
    @ResponsePayload
    public OutputSOATest hello(@RequestPayload InputSOATest req) {
        return studentService.hello(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentById")
    @ResponsePayload
    public GetStudentResponse getStudent(@RequestPayload GetStudentById req) {
        return studentService.getStudent(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createStudentRequest")
    @ResponsePayload
    public CreateStudentResponse createStudent(@RequestPayload CreateStudentRequest req) {
        return studentService.createStudent(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "displayAllStudentsRequest")
    @ResponsePayload
    public DisplayAllStudentsResponse displayAllStudents(@RequestPayload DisplayAllStudentsRequest req) {
        return studentService.displayAllStudents(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteStudentByIdRequest")
    @ResponsePayload
    public DeleteStudentByIdResponse deleteStudentById(@RequestPayload DeleteStudentByIdRequest req) {
        return studentService.deleteStudentById(req);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest req) {
        return studentService.updateStudent(req);
    }
}
//add update functionality (can update information about particular student)