package org.example.controller;

import org.example.entity.JournalEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    Map<Long, JournalEntry> entries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAllEntries() {
        return new ArrayList<>(entries.values());
    }

    @GetMapping("/{id}")
    public JournalEntry getEntryById(@PathVariable Long id) {
        return entries.get(id);
    }

    @PostMapping
    public Boolean addEntry(@RequestBody JournalEntry entry) {
           entries.put(entry.getId(), entry);
           return true;
    }

    @PutMapping("/{id}")
    public JournalEntry updateEntry(@PathVariable Long id, @RequestBody JournalEntry entry){
        entries.put(id, entry);
        return entry;
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEntry(@PathVariable Long id) {
        entries.remove(id);
        return true;
    }
}
