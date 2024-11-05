package com.ganeshgc.springbootwithjunitandmockito.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private Integer id;
    private String name;
    private int age;
}
