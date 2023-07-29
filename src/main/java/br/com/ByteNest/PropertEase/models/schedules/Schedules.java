package br.com.ByteNest.PropertEase.models.schedules;

import br.com.ByteNest.PropertEase.models.clients.Client;
import br.com.ByteNest.PropertEase.models.employees.Employee;
import br.com.ByteNest.PropertEase.models.realty.Realty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.PackagePrivate;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Schedules")
@Data
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employeeId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "clients_id", referencedColumnName = "id")
    private Client clientId;
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "realty_id", referencedColumnName = "id")
    private Realty realtyId;
    private Date scheduled;
}
