package com.example.demo.repository;

import com.example.demo.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository <Product, String> {
    // Additional query methods can be defined here if needed

    default String getZipCodeById(String id){
        Product product = findById(id).orElse(null);
        return product != null && product.getAddress() != null ? product.getAddress().getZipCode() : null;
    };
}
