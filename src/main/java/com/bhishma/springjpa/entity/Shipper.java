package com.bhishma.springjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Shipper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String shipperName;
}
