package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {


    private  final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }





    @PostMapping("/students")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student post(
         @RequestBody Student student
    ) {
          return  studentRepository.save(student);
     }

    @GetMapping("/students")
     public List<Student> findAStudent(
     ) {
        return  studentRepository.findAll();
    }

    @GetMapping("/students/{student-id}")
     public List<Student> findAStudentById(
            @PathVariable("student-id") Integer id
    ) {
        return Collections.singletonList(studentRepository.findById(id).orElse(new Student()));
    }

    @GetMapping("/students/search/{student-name}")
    public List<Student> findAStudentByFirsname(
            @PathVariable("student-name") String name

    ) {
        return  studentRepository.findAllByFirstNameContaining(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id

    ){
           studentRepository.deleteById(id);

    }




}
