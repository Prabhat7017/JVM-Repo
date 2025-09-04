package org.example.service;

import org.bson.types.ObjectId;
import org.example.entity.JournalEntryV2;
import org.example.entity.User;
import org.example.repository.JournalEntryRepo;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired
    private RedisService redisService;

    public User findByUsername(String username) {
        User user = redisService.getRedit(username);
        if(user != null) {
            System.out.println("User found in Redis cache !");
        }else{
            System.out.println("User not found in Redis cache. Fetching from MongoDB...");
            user = userRepo.findByUsername(username);
            if(user != null) {
                redisService.setRedit(username, user, 300l);
            }
        }
        return user;
    }

    public User addUser(User user) {
        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public void deleteUser(ObjectId id) {
        User user = userRepo.findById(id).orElse(null);
        if(user == null) {
            return;
        }
        List<JournalEntryV2> entries = user.getJournals();
        journalEntryRepo.deleteAll(entries);
        try {
            userRepo.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public User updateUser(String username, User user) {
        User existingUser = userRepo.findByUsername(username);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername() != null && !user.getUsername().equals(" ") ? user.getUsername() : existingUser.getUsername());
            existingUser.setPassword(user.getPassword() != null && !user.getPassword().equals(" ") ? user.getPassword() : existingUser.getPassword());
            return userRepo.save(existingUser);
        }
        return null;
    }
}
