package br.com.ByteNest.PropertEase.models.clients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
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

    public Client(RegisterClientData data) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.preferences = preferences;
    }
}

