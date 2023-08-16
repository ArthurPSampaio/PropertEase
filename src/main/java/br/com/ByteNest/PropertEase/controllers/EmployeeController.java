package br.com.ByteNest.PropertEase.controllers;

import br.com.ByteNest.PropertEase.models.employees.Employee;
import br.com.ByteNest.PropertEase.models.employees.EmployeeRepository;
import br.com.ByteNest.PropertEase.models.employees.RegisterEmployeeData;
import br.com.ByteNest.PropertEase.services.EmployeeServices;
import org.hibernate.annotations.SQLDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping
    @Transactional
    public ResponseEntity<String> register(@RequestBody @Validated RegisterEmployeeData data) {
        return employeeServices.register(data);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> getAllWithPages(@RequestParam(defaultValue = "0") int page) {
        return employeeServices.getAllWithPages(page);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getEmployeeById (@PathVariable UUID id) {
        return employeeServices.getEmployeeById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateAllEmployeeInfo (@PathVariable UUID id, @RequestBody RegisterEmployeeData data) {
        return employeeServices.updateAllEmployeeInfo(id, data);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<?> softDeleteEmployeeResponseEntity(@PathVariable UUID id) {
        return employeeServices.softDeleteEmployeeResponseEntity(id);
    }
}
