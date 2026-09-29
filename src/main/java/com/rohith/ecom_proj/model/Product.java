package com.rohith.ecom_proj.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Column(name = "description")
    private String desc;
    private String brand;
    private BigDecimal price;
    private String category;
    private boolean available;
    private Integer stockQuantity;


}
