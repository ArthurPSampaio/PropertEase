package br.com.ByteNest.PropertEase.services;


import br.com.ByteNest.PropertEase.models.employees.Employee;
import br.com.ByteNest.PropertEase.models.employees.EmployeeRepository;
import br.com.ByteNest.PropertEase.models.employees.RegisterEmployeeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository repository;

    public ResponseEntity<String> register(@RequestBody @Validated RegisterEmployeeData data) {
        Employee employee = new Employee(data);
        repository.save(employee);

        return new ResponseEntity<>("Employee created", HttpStatus.CREATED);
    }

    public ResponseEntity<Page<Employee>> getAllWithPages(@RequestParam(defaultValue = "0") int page){
        int definedSize = 5;

        Pageable pageable = PageRequest.of(page, definedSize);
        Page<Employee> employees = repository.findAll(pageable);

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    public ResponseEntity<?> getEmployeeById (@PathVariable UUID id) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if(optionalEmployee.isPresent()) {
            return new ResponseEntity<>(optionalEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("This employee does not exist", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updateAllEmployeeInfo (@PathVariable UUID id, @RequestBody RegisterEmployeeData data) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.updateEmployeeInfo(data);
            repository.save(employee);
            return new ResponseEntity<>(employee.getName() + " was updated", HttpStatus.OK);
        }

        return new ResponseEntity<>("This employee does not exist", HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<?> softDeleteEmployeeResponseEntity (@PathVariable UUID id) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if(optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setDeleted(true);
            repository.save(employee);

            return new ResponseEntity<>(employee.getName() + " was deleted", HttpStatus.OK);
        }

        return new ResponseEntity<>("This employee does not exist", HttpStatus.NOT_FOUND);
    }
}
