package com.ganeshgc.springbootwithjunitandmockito.student;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The student DTo is null");
        }
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
       student.setAge(dto.getAge());
        return student;
    }
    public StudentResponse toStudentResponse(Student student){
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        return response;
    }
}
