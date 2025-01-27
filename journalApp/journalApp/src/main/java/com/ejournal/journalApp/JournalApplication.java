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
@EnableTransactionManagement // this tells spring to find all the methods with transactional written on them, then for each method it makes a transactional context, i.e. all db operation in that methods are to be treated as one, thus we achieved atomicity. And it also helps achieve Isolation
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
<<<<<<< HEAD
* */

/*
* Spring Security -> customizable security framework used in Spring Boot Applications
* by default, Spring Security uses HTTP Basic Authentication
* this means the client sends an authorization header
*
* Authorization: Basic <encoded-string>
* Server decodes the string, extracts the username and password and verifies them.
* string is made like username:password which is encoded using base 64
*
* if we have not created a user yet, spring gives us a username and password
* we can also create them in application.properties
* we can set this as spring.security.user.name and password
=======
* */

/*
* Class path: it is ia list of jars and directories which is used by jvm
* jvm require byte code, this byte code is kept in the class path
* so class path is way to tell jvm where to search for
* so we get class files, jars and configuration files in class path
*
* so the path of src>main>resources is by default added in class path, so spring boot automatically finds application.properties file
* but if we externalize this then we need to configure
* we can also write our configurations in a yaml file
* so it has a format applications.yaml
* */


