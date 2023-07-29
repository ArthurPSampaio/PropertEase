package br.com.ByteNest.PropertEase.models.employees;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Employees")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String role;
    private String email;
    private String password;

    public Employee() {
    }

    public Employee(RegisterEmployeeData data) {
        this.name = data.name();
        this.role = data.role();
        this.email = data.email();
        this.password = data.password();
    }
}
