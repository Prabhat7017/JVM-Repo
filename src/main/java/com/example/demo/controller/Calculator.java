package com.example.demo.controller;

import com.example.demo.models.Multiplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculator")
public class Calculator {
    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
         return a + b;
    }
    @PostMapping("/multiply")
    public ResponseEntity greet(@RequestBody Multiplication req) {
        return ResponseEntity.ok("Multiplication : " + req.getValue1() * req.getValue2());
    }
}