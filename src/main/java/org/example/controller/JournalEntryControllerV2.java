package org.example.controller;

import org.bson.types.ObjectId;
import org.example.entity.JournalEntry;
import org.example.entity.JournalEntryV2;
import org.example.entity.User;
import org.example.service.JournalEntryService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journalV2")
public class JournalEntryControllerV2 {


    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public ResponseEntity<List<JournalEntryV2>> getAllEntries(@PathVariable String username) {
            User user = userService.findByUsername(username);
            List<JournalEntryV2> userEntries = user.getJournals();
            if(userEntries != null && !userEntries.isEmpty()){
                return new ResponseEntity<>(userEntries, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<JournalEntryV2> getEntryById(@PathVariable ObjectId id) {
        JournalEntryV2 entry = journalEntryService.findById(id);
        if(entry != null){
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{username}")
    public ResponseEntity<JournalEntryV2> addEntry(@PathVariable String username, @RequestBody JournalEntryV2 entry) {
           JournalEntryV2 savedEntry = journalEntryService.saveEntry(username, entry);
           if(savedEntry != null){
               return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
           }
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JournalEntryV2> updateEntry(@PathVariable ObjectId id, @RequestBody JournalEntryV2 newEntry){
        JournalEntryV2 oldEntry = journalEntryService.findById(id);
        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals(" ") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals(" ") ? newEntry.getContent() : oldEntry.getContent());
            JournalEntryV2 updatedEntry = journalEntryService.saveEntry(oldEntry);
            return new ResponseEntity<>(updatedEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{username}/{id}")
    public ResponseEntity deleteEntry(@PathVariable String username, @PathVariable ObjectId id) {
        return journalEntryService.deleteEntry(username, id) == true ? new ResponseEntity(HttpStatusCode.valueOf(200)) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
