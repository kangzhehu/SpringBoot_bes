package com.example.bes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table {
    private int id;
    private String number;
    private String name;
    private String state;
    private String region;
    private String classification;
    private String area;
    private double lon;
    private double lat;
    private String products;
    private String notes;
    private double tungsten;
    private double cutter;
    private double copper;
    private double silver;
    private double lead;
    private double zinc;
    private double tantalum;
    private double niobium;
    private double tombarthite;

    private double fluorite;
    private double other;
}
