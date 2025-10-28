package com.example.demo.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {


    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto("jane", "doe", "jane@gmail.com", 1);

        Student student = mapper.toStudent(dto);
        Assertions.assertEquals(dto.firstName(), student.getFirstName());
        Assertions.assertEquals(dto.lastName(), student.getLastName());
        Assertions.assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        Assertions.assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void shouldMaptoStudentResponsedtodto() {
        Student student = new Student("jane", "aris", "azer@gmail.com", 12);

        StudentResponsedto s = mapper.toStudentResponsedto(student);
        Assertions.assertEquals(s.firstName(), student.getFirstName());
        Assertions.assertEquals(s.lastName(), student.getLastName());
        Assertions.assertEquals(s.email(), student.getEmail());

    }

    @Test
    public void shouldthrow_Nullexceptionexcep_when_studentdto_is_Null() {

        var exp=assertThrows(NullPointerException.class,()->mapper.toStudent(null));
        assertEquals("this studentdto should not be  null",exp.getMessage());

    }


}