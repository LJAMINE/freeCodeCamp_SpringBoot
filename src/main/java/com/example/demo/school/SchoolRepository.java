package com.example.demo.school;

import org.springframework.data.jpa.repository.JpaRepository;

interface SchoolRepository extends JpaRepository<School, Integer> {
}
