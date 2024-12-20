//package com.ejournal.journalApp.controller;
//
//import com.ejournal.journalApp.entity.JournalEntry;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/_journal")
//public class JournalEntryController {
//
//    private Map<Long,JournalEntry> journalEntries = new HashMap<>();
//
//    @GetMapping
//    public ArrayList<JournalEntry> getAll() {
//        return new ArrayList<>(journalEntries.values());
//    }
//
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry entry) {
//        journalEntries.put(entry.getId(), entry);
//        return true;
//    }
//
//    @GetMapping("id/{myId}") //in case of request variable it is passed as ?id=2
//    public JournalEntry getJournalById(@PathVariable Long myId) {
//        return journalEntries.get(myId);
//    }
//
//    @DeleteMapping("id/{myId}") //in case of request variable it is passed as ?id=2
//    public JournalEntry deleteJournalById(@PathVariable Long myId) {
//        return journalEntries.remove(myId);
//    }
//
//    @PutMapping("id/{myId}") //in case of request variable it is passed as ?id=2
//    public JournalEntry updateJournalById(@PathVariable Long myId,@RequestBody JournalEntry entry) {
//        return journalEntries.put(myId,entry);
//    }
//}
