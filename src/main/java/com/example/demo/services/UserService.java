//package com.example.demo.services;
//
//import com.example.demo.Entity.User;
//import com.example.demo.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public void createUser(User user) {
//        userRepository.saveUser(user);
//    }
//
//    public User readUser(String userId) {
//        return userRepository.getUser(userId);
//    }
//
//    public void deleteUser(String userId) {
//        userRepository.deleteUser(userId);
//    }
//}
