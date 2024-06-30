package com.example.demo.controller;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentDto;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping(path = "students/")
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    @GetMapping
//    public List<Student> getStudents() {
//        return studentService.getStudentList();
//    }

    @PutMapping(path = "insert")
    public ResponseEntity<Student> insertStudent(@RequestBody Student student) {
        Student response = studentService.insertStudent(student);
        return status(OK).body(response);
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<StudentDto>> getStudents() {
        List<StudentDto> response = studentService.getStudents();
        return CollectionUtils.isEmpty(response)
                ? status(NO_CONTENT).body(new ArrayList<>())
                : status(OK).body(response);
    }

    @GetMapping(path = "dto")
    public StudentDto student(){
        Student student = new Student(1L,"Simone","ciao@fake.it",LocalDate.EPOCH,22);
        return StudentMapper.INSTANCE.entityToDto(student);
    }




}
