package com.springrest.springrest.Controller;

import com.springrest.springrest.Model.Student;
import com.springrest.springrest.Service.StudentService;
import com.springrest.springrest.Wrapper.StudentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("hello")
    private String hello() {
        return "hello";
    }


    @GetMapping("getAllStud")
    private List<Student> getAllStudent() {
        return studentService.getAllStudents();
    }

    @PostMapping("addStud")
    private Student addNewStudent(@RequestBody Student student) {
        return studentService.addNewStudent(student);
    }

    @GetMapping("getById")
    private Optional<Student> getStudentById(@RequestParam("id") Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("getByName")
    private List<Student> getStudentByName(@RequestParam("name") String name) {
        return studentService.getStudentByName(name);
    }

    @GetMapping("getAllStudWithCount")
    private StudentWrapper getAllStudWithCount() {
        return studentService.getAllStudWithCount();
    }


}
