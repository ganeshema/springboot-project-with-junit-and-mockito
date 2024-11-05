package com.ganeshgc.springbootwithjunitandmockito.student;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

   @Test
    public void  saveStudentShouldSaveSuccessfully() {
       System.out.println("This is my first test");
       Student student = new Student();
       student.setAge(20);
       student.setName("Ganesh");
       when(studentRepository.save(student)).thenReturn(student);
       Student savedStudent = studentService.saveStudent(student);
       Assertions.assertNotNull(savedStudent);

    }

    @Test
    public void getAllStudentsShouldReturnSuccessfully() {
       System.out.println("This is my first test");
       Student student = new Student();
       student.setAge(20);
       student.setName("Ganesh");
       when(studentRepository.findAll()).thenReturn(List.of(student));
       List<Student> students = studentService.getAllStudents();
      assertNotNull(students);
    }
    @Test
    public void shouldReturnStudentByIdWhenExists() {
        Student student = new Student();
        student.setId(1);
        student.setAge(20);
        student.setName("Ganesh");
        when(studentRepository.findById(student.getId())).thenReturn(Optional.of(student));
        Student foundStudent = studentService.getStudentById(student.getId());
        assertEquals(1, foundStudent.getId());

    }

    @Test
    public void shouldUpdateStudentSuccessfully() {
        // Arrange
        Student student = new Student();
        student.setId(1);
        student.setName("Ganesh");
        student.setAge(20);
        when(studentRepository.save(student)).thenReturn(student);
        // Act
        Student updatedStudent = studentService.updateStudent(student);
        // Assert
        assertEquals(1, updatedStudent.getId());
        assertEquals("Ganesh", updatedStudent.getName());
        assertEquals(20, updatedStudent.getAge());
    }


}
