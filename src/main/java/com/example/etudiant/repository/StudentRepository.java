package com.example.etudiant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.etudiant.Student;

public interface StudentRepository
        extends JpaRepository<Student, Integer> {
}

