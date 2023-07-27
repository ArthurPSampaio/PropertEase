package br.com.ByteNest.PropertEase.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table (name = "Realties")
@Getter
@Setter
public class RealtyTable {

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String description;
    private String type;
    private String address;
    private Double area;
    private Integer rooms;
    private Integer bathroom;
    private Double price;
    private Integer status;
}