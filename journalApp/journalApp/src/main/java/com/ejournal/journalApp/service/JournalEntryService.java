package com.ejournal.journalApp.service;

import com.ejournal.journalApp.entity.JournalEntry;
import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserService userService;

    // implemented by MongoTransactionManager, which is inherited by platform transaction manager
    // this also gives "Transaction numbers are only allowed on a replica set member or mongos" error

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        try {
            User user = userService.findByUsername(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            // we need to make sure if it is getting added in journal, then it gets added to a user also, or else nothing is done
            // to make sure this happens we make it as a transaction
            user.getJournalEntries().add(saved);
            userService.saveEntry(user);
        }catch (Exception e){
            log.error("Exception ",e);
            throw new RuntimeException("error occurred while saving entry");
        }
    }

    public void saveEntry(JournalEntry journalEntry) {
        try {
            journalEntryRepository.save(journalEntry);
        }catch (Exception e){
            log.error("Exception ",e);
        }
    }



    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> getById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public void deleteById(ObjectId id,String userName) {
        try{
            User user = userService.findByUsername(userName);
            user.getJournalEntries().removeIf(journalEntry -> journalEntry.getId().equals(id));
            userService.saveEntry(user);
            journalEntryRepository.deleteById(id);
        }catch (Exception e){
            log.error("Exception ",e);
            throw new RuntimeException("error occurred while deleting entry");
        }
    }
}
