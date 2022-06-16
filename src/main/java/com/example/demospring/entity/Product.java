package com.example.demospring.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class Product {
    private int id;
    private String name;
    private String description;
}
