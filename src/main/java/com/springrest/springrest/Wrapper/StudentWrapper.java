package com.springrest.springrest.Wrapper;

import com.springrest.springrest.Model.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentWrapper {
    private int count;
    private List<Student> studentList;
}
