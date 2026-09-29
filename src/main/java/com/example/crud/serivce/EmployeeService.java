package com.example.crud.serivce;

import com.example.crud.entity.Employee;
import com.example.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
      return employeeRepository.findAll();
    }

    public Employee getByName(String name){
        return employeeRepository.findByName(name);
    }

    public void deleteEmployee(String id){
        employeeRepository.deleteById(id);
    }
}
