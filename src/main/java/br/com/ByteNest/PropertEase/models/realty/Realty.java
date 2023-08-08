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
    private Integer status = 1;

    public Realty () {}

    public Realty(RegisterRealtyData data) {
        this.title = data.title();
        this.description = data.description();
        this.type = data.type();
        this.address = data.address();
        this.area = data.area();
        this.rooms = data.rooms();
        this.bathroom = data.bathroom();
        this.price = data.price();
    }

    public void updateRealtyInfo(RegisterRealtyData data){
        this.title = data.title();
        this.description = data.description();
        this.type = data.type();
        this.address = data.address();
        this.area = data.area();
        this.rooms = data.rooms();
        this.bathroom = data.bathroom();
        this.price = data.price();
        this.status = data.status();
    }

    public void updateRealtyStatus(RegisterRealtyData data) {
        this.status = data.status();
    }
}
