//package com.example.demo.controller;
//
//import com.example.demo.Entity.User;
//import com.example.demo.services.UserService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @PostMapping
//    public String createUser(@RequestBody User user) {
//        userService.createUser(user);
//        return "User created!";
//    }
//
//    @GetMapping("/{userId}")
//    public User getUser(@PathVariable String userId) {
//        return userService.readUser(userId);
//    }
//
//    @DeleteMapping("/{userId}")
//    public String deleteUser(@PathVariable String userId) {
//        userService.deleteUser(userId);
//        return "User deleted!";
//    }
//}
