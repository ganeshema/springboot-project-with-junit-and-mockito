package com.ganeshgc.springbootwithjunitandmockito.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDTOToStudent() {
      StudentDto studentDto = new StudentDto();
      studentDto.setId(1);
      studentDto.setName("Ganesh");
      studentDto.setAge(20);
      Student student=studentMapper.toStudent(studentDto);
      assertEquals(studentDto.getId(), student.getId());
      assertEquals(studentDto.getName(), student.getName());
      assertEquals(studentDto.getAge(), student.getAge());
    }
    @Test
    public void should_throw_Null_pointer_exception_when_studentDto_is_null() {
       assertThrows(NullPointerException.class, ()->studentMapper.toStudent(null));
    }

    @Test
    public void shouldMapStudentToStudentResponse() {
        //given
        Student student = new Student();
        student.setId(1);
        student.setName("Ganesh");
        student.setAge(20);
        //when
        StudentResponse studentResponse=studentMapper.toStudentResponse(student);
        //then
        assertEquals(student.getId(), studentResponse.getId());
        assertEquals(student.getName(), studentResponse.getName());
        assertEquals(student.getAge(), studentResponse.getAge());

    }


}