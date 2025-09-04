package org.example.controller;

import jakarta.ws.rs.GET;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")

public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }

    @PostMapping("/greet")
    public String greet(@RequestBody String name) {
        return "Hello, " + name + "!";
    }
}
