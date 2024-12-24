package com.ejournal.journalApp.entity;

// these classes are called as POJO -> plain old Java Object
// it just specifies how the journal entry will look like

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder

@Document(collection = "journal_entries") //we need to map this with a collection (table of database using this @Document)
@Data //instead of all the above constructors use this
@NoArgsConstructor //this is essential to use as @Data do not have No args constructor which is essential for deserialization i.e. from json to pojo conversion
public class JournalEntry {
    @Id // to map this as a primary key
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
}

// not required because of Lombok
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }
//
//    public ObjectId getId() {
//        return id;
//    }
//
//    public void setId(ObjectId id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
