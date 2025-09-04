package org.example.controller;

import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proxy-products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getZipcodeById/{id}")
    public ResponseEntity<String> getZipCode(@PathVariable String id) {
        return productService.getZipCode(id);
    }

    @GetMapping("/getAllProducts")
    public ResponseEntity getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
