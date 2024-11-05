package com.ganeshgc.springbootwithjunitandmockito.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentResponse {
    private Integer id;
    private String name;
    private int age;
}
