package org.example.service;

import jakarta.ws.rs.core.Response;
import org.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;
    private final String baseUrl = "http://localhost:8080/product";

    public ResponseEntity<String> getZipCode(String id){
        try {
            return restTemplate.getForEntity(baseUrl + "/getZipcodeById/" + id, String.class);
        }catch (HttpClientErrorException.NotFound e){
            return ResponseEntity.status(404).body("Product or Address for this product not found");
        }catch (Exception e){
            return ResponseEntity.status(500).body("Something went wrong" + e.getMessage());
        }
    }

    public ResponseEntity getAllProducts(){
        List<Product> products = restTemplate.getForObject(baseUrl + "/allProducts", List.class);
        return ResponseEntity.status(200).body(products);
    }

    public Product addProduct(Product product){
        return restTemplate.postForObject(baseUrl + "/addProduct", product, Product.class);
    }
}
