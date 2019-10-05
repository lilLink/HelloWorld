package com.helloworld.spring.controller;

import com.helloworld.spring.exception.EmployeeNotFoundException;
import com.helloworld.spring.model.Employee;
import org.springframework.web.bind.annotation.*;
import com.helloworld.spring.repository.EmployeeRepository;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository){
        this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all(){
        return repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployees(@RequestBody Employee newEmployee){
        return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
    Employee one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PutMapping("/employees/{id}")
    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id){
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    return repository.save(employee);
                })
                .orElseGet(() ->{
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/employee/{id}")
    void deleteEmployee(@PathVariable Long id){
        repository.deleteById(id);
    }
}
