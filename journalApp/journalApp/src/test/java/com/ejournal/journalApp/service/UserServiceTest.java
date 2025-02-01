package com.ejournal.journalApp.service;

import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest // this will ensure that Spring Application Context gets started, if we do not do that, then we cannot use autowired, as autowired gives us a bean
@ActiveProfiles("dev") // this mean these tests will run only when active profile is dev
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Test
    public void testFindByUserName() {
        assertNotNull(userRepository.findByUserName("Ram"));
    }

//    @BeforeEach
//    @BeforeAll
//    @AfterAll
//    @AfterEach
//    eg: creating a scv and deleting before and after running a service

    @ParameterizedTest
    @ValueSource(strings = {
            "Ram",
            "Ramuss",
            "Shayam"
    })
    public void testFindByUserName2(String name) {
        assertNotNull(userRepository.findByUserName(name));
    }

    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user) {
        assertNotNull(userService.saveNewUser(user));
    }

    @Disabled // if we do not want to run a test
    @Test
    public void testUserEntries(){
        User user = userRepository.findByUserName("Ram");
        assertFalse(user.getJournalEntries().isEmpty());
    }

    @ParameterizedTest // if we are passing the parameters to test ourselves
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    }) // we can also use csv file here, by giving the path for the csv file, by mentioning it in the resources, by telling the option to skip header or not
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b,"failed for: "+a+" "+b+" "+expected);
    }
}


