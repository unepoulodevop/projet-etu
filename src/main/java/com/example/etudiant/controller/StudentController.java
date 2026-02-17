package com.example.etudiant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.etudiant.Student;
import com.example.etudiant.repository.StudentRepository;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository repo;

    // Ajouter un étudiant
    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return repo.save(student);
    }

    // Afficher tous les étudiants
    @GetMapping
    public List<Student> getStudents(){
        return repo.findAll();
    }
}
