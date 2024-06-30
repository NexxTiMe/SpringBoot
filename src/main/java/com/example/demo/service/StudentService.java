package com.example.demo.service;

import com.example.demo.mapper.StudentMapper;
import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentDto;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    public List<Student> getStudentList() {
//        return List.of(new Student(1L, "Simone", "simone.melis@fake.com", LocalDate.of(2001, Month.JULY, 19), 22),
//                new Student(1L, "Simone", "simone.melis@fake.com", LocalDate.of(2001, Month.JULY, 19), 22));
//    }

    public Student insertStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<StudentDto> getStudents() {
        return StudentMapper.INSTANCE.mapToListDto(studentRepository.findAll());
    }
}
