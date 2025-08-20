package com.example.demo.controller;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Product;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getZipcodeById/{id}")
    public String getZipcodeById(@PathVariable String id) {
        return "Zip Code: " + productService.getAddressById(id);
    }
    @GetMapping("/allProducts")
    public List <Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct( @RequestBody Product product) {
        return productService.saveProduct(product);
    }
    @GetMapping("/getProductById/{id}")
    public Product getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }
    @PutMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public boolean deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProduct(id);
            return true;
        } catch (Exception e) {
            return false; // or handle the exception as needed
        }
    }
}
