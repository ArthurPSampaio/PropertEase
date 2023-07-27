package br.com.ByteNest.PropertEase.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Visits")
@Data
public class VisitsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private ClientsTable clientId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private RealtyTable realtyId;
    private Date scheduled;
}
