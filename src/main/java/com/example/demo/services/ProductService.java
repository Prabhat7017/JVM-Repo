package com.example.demo.services;


import com.example.demo.Entity.Product;
import com.example.demo.repository.ProductRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ResponseEntity.status(200).body(products);
    }

    public ResponseEntity<String> getZipCode(String id) {
        String zipCode = productRepository.getZipCodeById(id);
        return zipCode != null ?
                ResponseEntity.status(200).body("Zip Code: " + zipCode) :
                ResponseEntity.status(404).body("Zip Code not found, maybe address is missing for this product");
    }
    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
    public Product updateProduct(String id, Product product){
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName()!=null ? product.getName() : existingProduct.getName());
            existingProduct.setPrice(product.getPrice() != 0 ? product.getPrice() : existingProduct.getPrice());
            existingProduct.setAddress(product.getAddress() != null ? product.getAddress() : existingProduct.getAddress());
            // Add any other fields that need to be updated
            return productRepository.save(existingProduct);
        }
        return null; // or throw an exception if preferred
    }
}
