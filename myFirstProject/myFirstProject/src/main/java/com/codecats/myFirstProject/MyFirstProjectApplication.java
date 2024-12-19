package com.codecats.myFirstProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(MyFirstProjectApplication.class, args);
	}
}
/*
* in java we create a object by ourself
* in spring we ask spring to give me a object, this means we have
* inverted the traditional process, i.e. control inversion
* this person now ask IOC (inversion of control) container to get the object
* IOC is provided by spring, it keep all the classes built in the project with itself
*
* what is application context-> is a way to achieve IOC container
* IOC container scans for all the classes (we give the directory to scan)
* It do not store all classes, but only special classes
* if we have @component above the class, then it keep inside it
* these annotation can be written on (class, interface, methods, field)
* annotation provides information
*
* @component registers the class automatically as Spring Bean
* Bean is a object in spring
* or we can say, if IOC container only regiters those classes in it which are beans
*
*
* Now @SpringBootApplication do three tasks (it is given to only class in the whole project)
* @Configuration -> if we write this on a class, then it suggest this class will provide some configuration
* 					it is used with @Bean annotation, now bean is made by @component
* 					but also using @Bean, this is not on class but for a function
* 					so if we write @Configuration over a class, then we can create a @Bean in that class
* @EnableAutoConfiguration -> if we want to run mongoDB, we just need to add its dependency
*                             then in application properties we tell about server and password, then everthing will be autoconfigured
* @Component -> It gives order to spring to scan for  beans in project
* 				only package in com.codecats.myFirstProject folder can get scanned
* */
