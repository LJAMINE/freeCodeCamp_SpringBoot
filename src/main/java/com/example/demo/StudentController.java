package com.example.demo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class StudentController {


    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @PostMapping("/students")
    public StudentResponsedto post(
            @RequestBody StudentDto studentDto
    ) {
        var student = toStudent(studentDto);
        var savedStudent= studentRepository.save(student);
        return toStudentResponsedto(savedStudent);
    }




    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }


    private StudentResponsedto toStudentResponsedto(Student student){
        return new StudentResponsedto(student.getFirstName(),student.getLastName(),student.getEmail());
    }

    @GetMapping("/students")
    public List<Student> findAStudent(
    ) {
        return studentRepository.findAll();
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
        return studentRepository.findAllByFirstNameContaining(name);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(
            @PathVariable("student-id") Integer id

    ) {
        studentRepository.deleteById(id);

    }


}
