package br.com.ByteNest.PropertEase.controllers;

import br.com.ByteNest.PropertEase.models.employees.Employee;
import br.com.ByteNest.PropertEase.models.employees.EmployeeRepository;
import br.com.ByteNest.PropertEase.models.employees.RegisterEmployeeData;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Validated RegisterEmployeeData data) {
        Employee employee = new Employee(data);
        repository.save(employee);

        return new ResponseEntity<>("Employee created", HttpStatus.CREATED);
    }
}
