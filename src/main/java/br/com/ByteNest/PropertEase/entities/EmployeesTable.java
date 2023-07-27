package br.com.ByteNest.PropertEase.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "Employees")
@Getter
@Setter
public class EmployeesTable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String role;
    private String email;
    private String password;



}
