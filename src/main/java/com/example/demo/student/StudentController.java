package com.example.demo.student;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponsedto saveStudent(
            @RequestBody StudentDto dto
    ) {
        return studentService.saveStudent(dto);
    }


    @GetMapping("/students")
    public List<StudentResponsedto> findAStudent(
    ) {
        return studentService.findAStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponsedto findAStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return studentService.findAStudentById(id);
    }

    @GetMapping("/students/search/{student-name}")
    public List<StudentResponsedto> findAStudentByFirsname(
            @PathVariable("student-name") String name
    ) {
        return studentService.findAllByFirstName(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id

    ) {
        studentService.delete(id);

    }


}
