package com.wcc.app.mapdistance.model;

import lombok.Data;
import org.springframework.ui.Model;

import javax.persistence.*;

@Entity
@Table(name = "postcodelatlng")
@Data
public class PostCodeLatLng {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String postcode;
    private double latitude;
    private double longitude;

}