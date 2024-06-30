package com.example.demo.mapper;

import com.example.demo.model.Student;
import com.example.demo.model.dto.StudentDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto entityToDto(Student entity);

    List<StudentDto> mapToListDto(List<Student> entities);
}
