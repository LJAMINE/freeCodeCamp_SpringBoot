package com.example.demo;


import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private Integer id;
    private String bio;

    public StudentProfile(Integer id, String bio) {
        this.id = id;
        this.bio = bio;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private  Student student;


    public StudentProfile() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
