package com.ganeshgc.springbootwithjunitandmockito.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }
    // Find student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable int id) {
        // Assuming the delete logic is implemented in the service
        boolean isDeleted = studentService.deleteStudentById(id);

        if (isDeleted) {
            return ResponseEntity.ok(String.format("Deleted the student having id %d", id));
        } else {
            return ResponseEntity.status(404).body(String.format("Student with id %d not found", id));
        }
    }

    // Update student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id, @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(studentDetails));
    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.saveStudent(studentDetails));
    }

}
