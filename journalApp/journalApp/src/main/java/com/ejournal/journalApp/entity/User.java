package com.ejournal.journalApp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;

    @Indexed(unique = true) // indexing the bd about userName, along with this set application properties for indexing as well
    @NonNull
    private String userName;

    @NonNull
    private String password;

    @DBRef // this means this list will keep reference of the journal entries
    private List<JournalEntry> journalEntries=new ArrayList<JournalEntry>();

}
