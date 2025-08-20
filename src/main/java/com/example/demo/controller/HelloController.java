package com.example.demo.controller;

import com.example.demo.controller.GreetRequest.GreetRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam String name) {
        return "Hello " + name;
    }
    @PostMapping("/greet")
    public ResponseEntity greet(@RequestBody GreetRequest req) {
        return ResponseEntity.ok("Hi " + req.getName());
    }
}