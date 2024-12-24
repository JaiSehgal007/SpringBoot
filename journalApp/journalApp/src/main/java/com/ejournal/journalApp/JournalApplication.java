package com.ejournal.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

}

/*
* ORM -> object relational mapping, in this what happens is that, the class of the object-oriented language is mapped to the table in the database
* i.e. we will make changes in the class which will make changes in the database
*
* ORM frameworks like Hibernate helps to do this
*
* Java Persistence API : it provides a set of rules to achieve ORM
* JPA is a way to achieve ORM, using java interfaces and classes and requires a persistence provider for implementation
* i.e. JPA is a set of rules which are implemented by persistence provider to achieve ORM
*
* JPA Persistence Provider example are Hibernate, EclipseLink and OpenJPA
*
* Spring Data JPA-> built ont the top of JPA, but it is not a JPA implementation itself. It simplifies JPA by providing higher Abstraction and utility
* but to use Spring Data JPA we need a JPA implementation
*
* in MongoDB JPA is not required, it instead used Spring Data MongoDB for persistence provider
*
* Query Method DSL and Criteria API -> 2 methods to interact with database when using Spring Data JPA or Spring Data MongoDB
*  |                            |
* based on method              dynamic and programmatic approach to make custom and complex queries
* naming convention
* */


/*
* Lombok -> reduce boilerplate code (getter, setter, constructors, etc.)
* lombok do this automatically at the time of compilation, we just need to make annotation
* */