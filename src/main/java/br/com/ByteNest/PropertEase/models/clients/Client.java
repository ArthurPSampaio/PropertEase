package br.com.ByteNest.PropertEase.models.clients;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Clients")
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String preferences;

    public Client() {}

    public Client(RegisterClientData data) {
        this.name = data.name();
        this.email = data.email();
        this.phone = data.phone();
        this.preferences = data.preferences();
    }
}

