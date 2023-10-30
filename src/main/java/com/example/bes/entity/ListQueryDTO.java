package com.example.bes.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListQueryDTO {
    private int page;
    private int limit;

    private String name;

    private String region;

    private String classification;

    private String sort;
}
