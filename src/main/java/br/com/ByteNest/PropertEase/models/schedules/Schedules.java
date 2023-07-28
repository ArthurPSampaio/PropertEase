package br.com.ByteNest.PropertEase.models.schedules;

import br.com.ByteNest.PropertEase.models.clients.Client;
import br.com.ByteNest.PropertEase.models.realty.Realty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Visits")
@Data
public class Schedules {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Client clientId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Realty realtyId;
    private Date scheduled;
}
