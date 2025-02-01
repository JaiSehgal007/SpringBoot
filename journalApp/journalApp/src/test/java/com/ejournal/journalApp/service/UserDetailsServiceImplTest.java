package com.ejournal.journalApp.service;

import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

//@SpringBootTest -> we wont be using this as it will be starting the whole boot application
public class UserDetailsServiceImplTest {

    @InjectMocks
    private UserDetailsServiceImpl userDetailsServiceImpl;

//    @MockBean // use this instead of @Mock Annotation -> when using @SpringBootTest Annotation, else use @Mock, this is done when we just want to mock the things partially
    @Mock
    private UserRepository userRepository;

    @BeforeEach // as UserRepository bean won't be created, as this is not initializing the springboot application, so before every test we need to initialize mocks
    void setUp() {
        MockitoAnnotations.initMocks(this); // this means initialize all mocks of this call and also inject them
    }

    @Test
    void loadUserByUsernameTest() {
        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("Ramu").password("inwjdw").roles(new ArrayList<>()).build());
//        when(userRepository.findByUserName("Ramu")).thenReturn(User.builder().userName("Ramu").password("inwjdw").build());
        UserDetails user=userDetailsServiceImpl.loadUserByUsername("Ram");
        Assertions.assertNotEquals(null,user);
    }
}

// now as we are autowiring again ang again to test the code
// instead of this we can think of mocking
// now let say we want to test a method of a service

// in the service below, we just want to test without testing for the userRepository which was autowired
// so we should mock this
//public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    User user=userRepository.findByUserName(username);
//    if(user!=null){
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
//                .username(user.getUserName())
//                .password((user.getPassword()))
//                .roles(user.getRoles().toArray(new String[0]))
//                .build();
//        return userDetails;
//    }
//    throw new UsernameNotFoundException("User not found");
//}

// this means we are creating a fake repository
// i.e. whenever a loadByUserName is called then in that case give a fake user for the testing purpose
