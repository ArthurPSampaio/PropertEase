package br.com.ByteNest.PropertEase.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Clients")
@Data
public class ClientsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String preferences;


}
