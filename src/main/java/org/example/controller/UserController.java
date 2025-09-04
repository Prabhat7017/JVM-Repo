package org.example.controller;

import org.bson.types.ObjectId;
import org.example.entity.EmailDTO;
import org.example.entity.User;
import org.example.repository.UserRepoImpl;
import org.example.service.EmailSenderService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepoImpl userRepo;

    @Autowired
    private EmailSenderService emailSenderService;


    @GetMapping
    public List<User> getALlUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{username}")
    public User getUserById(@PathVariable  String username) {
        return userService.findByUsername(username);
    }

    @PutMapping("/update/{username}")
    public User updateUser(@PathVariable String username, @RequestBody User user) {
        return userService.updateUser(username, user);
    }

    @DeleteMapping("/delete/{username}")
    public boolean deleteUser(@PathVariable String username) {
        ObjectId id = userService.findByUsername(username).getId();
        try {
            userService.deleteUser(id);
            return true;
        } catch (Exception e) {
            return false; // or handle the exception as needed
        }
    }

    @GetMapping("/filteredUsers")
    public List<User> filteredUsers(){
        return userRepo.filterUsersByAge();
    }

    @PostMapping("/sendMail")
    public Boolean sendMail(@RequestBody EmailDTO emailDTO){
       return emailSenderService.sendEmail(emailDTO.getRecipient(), emailDTO.getSubject(), emailDTO.getBody());
    }

}
