package br.com.ByteNest.PropertEase.models.employees;

import br.com.ByteNest.PropertEase.models.realty.RegisterRealtyData;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import java.util.UUID;

@Entity
@Table(name = "Employees")
@Data
@SQLDelete(sql = "UPDATE Employee SET deleted = false WHERE role = 0")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String role;
    private String email;
    private String password;
    private Boolean deleted = Boolean.FALSE;

    public Employee() {
    }

    public Employee(RegisterEmployeeData data) {
        this.name = data.name();
        this.role = data.role();
        this.email = data.email();
        this.password = data.password();
    }

    public void updateEmployeeInfo(RegisterEmployeeData data) {
        this.name = data.name();
        this.role = data.role();
        this.email = data.email();
        this.password = data.password();
    }
}
