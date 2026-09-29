package com.example.crud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private Long productPrice;

//    public void setId(Long id) {this.id = id;}
//    public Long getId(){return this.id;}
//
//    public void setName(String name){this.productName = name;}
//    public String getName(){return productName;}
//    public void setProductPrice(Long price){this.productPrice = price;}
//    public Long getPrice(){return this.productPrice;}
}
