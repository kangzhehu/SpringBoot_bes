package com.example.bes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mine {
    private Integer id;
    private String number;
    private String name;
    private String region;
    private String classification;
    private String area;
    private double lon;
    private double lat;
    private String products;
    private String notes;
}
