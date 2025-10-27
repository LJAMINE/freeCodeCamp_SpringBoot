package com.example.demo.student;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }





    public StudentResponsedto saveStudent(StudentDto dto){
        var student = studentMapper.toStudent(dto);
        var savedStudent= studentRepository.save(student);
        return studentMapper.toStudentResponsedto(savedStudent);
    }

    public List<StudentResponsedto> findAStudents(){
        return studentRepository.findAll().stream().map(studentMapper::toStudentResponsedto).toList();
    }
    public StudentResponsedto findAStudentById(Integer id){
        return studentRepository.findById(id).map(studentMapper::toStudentResponsedto).orElse(null);
    }

    public List<StudentResponsedto> findAllByFirstName(String name){
        return studentRepository.findAllByFirstNameContaining(name).stream().map(studentMapper::toStudentResponsedto).toList();
    }

    public void delete(Integer id){
        studentRepository.deleteById(id);
    }
}
