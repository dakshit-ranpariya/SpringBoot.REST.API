package com.springrest.springrest.Service;

import com.springrest.springrest.Model.Student;
import com.springrest.springrest.Repository.StudentRepo;
import com.springrest.springrest.Wrapper.StudentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;


    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }

    public List<Student> getStudentByName(String name) {
        List<Student> students = studentRepo.findByName(name);
        List<Student> list = new ArrayList<>();
        for (Student student : students) {
            if (student.getEmail().contains(name)) list.add(student);
        }
        return list;
    }

    public StudentWrapper getAllStudWithCount() {
        return StudentWrapper.builder().count((int) studentRepo.count()).studentList(studentRepo.findAll()).build();
    }
}
