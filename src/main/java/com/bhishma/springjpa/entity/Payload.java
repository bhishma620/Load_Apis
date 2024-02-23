package com.bhishma.springjpa.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payload  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loadId;
    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;

    private int shipperId;

    private String date;
}
