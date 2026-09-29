package com.example.crud.serivce;

import com.example.crud.entity.Student;
import com.example.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
@Autowired
    private StudentRepository studentRepository;

public void add(Student student){
    studentRepository.save(student);
}

public List<Student> getAllStudent(){
    return studentRepository.findAll();
}

public Student getById(Long id){

    return studentRepository.findByStdId(id);
}
}
