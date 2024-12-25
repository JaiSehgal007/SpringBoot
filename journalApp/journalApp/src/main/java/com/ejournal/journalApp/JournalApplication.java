package com.ejournal.journalApp;

import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // this tells spring to find all the methods with transactional written on them, then for each method it makes a transactional context, i.e. all dbb operation in that methods are to be treated as one, thus we achieved atomicity. And it also helps achieve Isolation
public class JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}

	//in order to tell that MongoTransactionManager is the implementation of the platformTranactionManager
	//we need to create a bean
	//in this class we can create beans using methods
	// MongoDatabaseFactory helps to make a connection with the Mongo Database
	//Spring Automatically checks which Bean is implementing PTM
	//you could give any name to this method
	// this MongoDatabaseFactory will be passed by spring, it is a interface which is implemented by spring using the application configuration we specified
	// and the implementation of this is known as  SimpleMongoClientDatabaseFactory
	@Bean
	public PlatformTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}
	//	can be moving it to a separate package
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