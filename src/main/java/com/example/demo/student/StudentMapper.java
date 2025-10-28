package com.example.demo.student;


import com.example.demo.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student toStudent(StudentDto dto) {

        if (dto==null){
            throw  new NullPointerException("this studentdto should not be  null");
        }
        var student = new Student();
        student.setFirstName(dto.firstName());
//        student.setFirstName(dto.firstName().toUpperCase());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        school.setId(dto.schoolId());

        student.setSchool(school);

        return student;
    }


    public StudentResponsedto toStudentResponsedto(Student student){
        return new StudentResponsedto(student.getFirstName(),student.getLastName(),student.getEmail());
    }
}
