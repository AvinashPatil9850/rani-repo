package com.example.crud.controller;

import com.example.crud.entity.Student;
import com.example.crud.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public void add(@RequestBody Student student){
        studentService.add(student);
    }

    @GetMapping
    public List<Student> getAll(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{stdId}")
    public ResponseEntity<Student> getById(@PathVariable Long stdId){
        Student student= studentService.getById(stdId);
    if(student==null){
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(student);
    }
}
