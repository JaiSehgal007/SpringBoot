package com.ejournal.journalApp.controller;

import com.ejournal.journalApp.entity.JournalEntry;
import com.ejournal.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry entry) {
        entry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(entry);
        return true;
    }

    @GetMapping("id/{myId}") //in case of request variable it is passed as ?id=2
    public JournalEntry getJournalById(@PathVariable ObjectId myId) {
        return journalEntryService.getById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}") //in case of request variable it is passed as ?id=2
    public boolean deleteJournalById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}") //in case of request variable it is passed as ?id=2
    public JournalEntry updateJournalById(@PathVariable ObjectId myId,@RequestBody JournalEntry entry) {
        JournalEntry old = journalEntryService.getById(myId).orElse(null);

        if(old != null) {
            old.setTitle(entry.getTitle()!=null && !entry.getTitle().isEmpty() ?entry.getTitle():old.getTitle());
            old.setContent(entry.getContent()!=null && !entry.getContent().isEmpty() ?entry.getContent():old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}
