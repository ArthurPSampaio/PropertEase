package br.com.ByteNest.PropertEase.models.realty;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table (name = "Realty")
@Data
public class Realty {

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