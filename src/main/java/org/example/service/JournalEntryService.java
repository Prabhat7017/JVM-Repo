package org.example.service;

import jakarta.transaction.Transactional;
import org.bson.types.ObjectId;
import org.example.entity.JournalEntryV2;
import org.example.entity.User;
import org.example.repository.JournalEntryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalEntryService {
    @Autowired
    private JournalEntryRepo journalEntryRepo;

    @Autowired UserService userService;

    public List<JournalEntryV2> findAllEntries(){
        return journalEntryRepo.findAll();
    }

    public JournalEntryV2 findById(ObjectId id){
        return journalEntryRepo.findById(id).orElse(null);
    }

    @Transactional
    public JournalEntryV2 saveEntry(String username, JournalEntryV2 entry){
       try {
           entry.setCreatedAt(LocalDateTime.now());
           JournalEntryV2 savedEntry = journalEntryRepo.save(entry);
           User user = userService.findByUsername(username);
           user.getJournals().add(savedEntry);
           userService.addUser(user);
           return savedEntry;
       } catch (Exception e){
           System.out.println("Error saving entry: " + e.getMessage());
           throw new RuntimeException("Error saving entry");
       }

    }

    public JournalEntryV2 saveEntry(JournalEntryV2 entry){
        return journalEntryRepo.save(entry);
    }

    public Boolean deleteEntry(String username, ObjectId id){
        if(!journalEntryRepo.existsById(id)){
            return false;
        }
        JournalEntryV2 entry= journalEntryRepo.findById(id).orElse(null);
        User user = userService.findByUsername(username);
        user.getJournals().removeIf(e -> e.getId().equals(id));
        userService.addUser(user);
        journalEntryRepo.deleteById(id);
        return true;
    }
}
