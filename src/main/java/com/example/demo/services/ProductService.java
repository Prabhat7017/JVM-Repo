package com.example.demo.services;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String getAddressById(String id) {
        return productRepository.getZipCodeById(id);
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
