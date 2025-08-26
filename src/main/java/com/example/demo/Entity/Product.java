package com.example.demo.Entity;

import com.example.demo.annotation.MaskPII;
import com.example.demo.enums.MaskingType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class Product {
    @MaskPII(type= MaskingType.ID)
    @Id
    private String id;
    @MaskPII(type = MaskingType.ID)
    private String name;
    private double price;
    private Address address;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
