package com.example.crud.controller;

import com.example.crud.entity.Employee;
import com.example.crud.serivce.EmployeeService;
import com.example.crud.serivce.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/{name}")
    public Employee getByName(@PathVariable String name) {
        return employeeService.getByName(name);
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<Employee> DeleteEmployee(@PathVariable String id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();

    }
}
