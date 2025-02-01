package com.ejournal.journalApp.service;

import com.ejournal.journalApp.entity.User;
import com.ejournal.journalApp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // creating a logging instance -> but we won't be needing this as we are using Slf4j, which automatically add this for us
    // private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);
    // every class will be having its own instance for this logger

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public Optional<User> saveNewUser(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER"));
            userRepository.save(user);
            return Optional.of(user);
        }catch (Exception e){
            log.error("Exception occurred for {} :",user.getUserName(),e);
//            log.info("This is info");
//            log.warn("This is a warning");
//            log.debug("This is debugging");
//            log.trace("Tracing");
              log.error("Exception ",e);
            return Optional.empty();
        }
    }

    public Optional<User> saveAdmin(User user) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(List.of("USER","ADMIN"));
            userRepository.save(user);
            return Optional.of(user);
        }catch (Exception e){
            log.error("Exception ",e);
            return Optional.empty();
        }
    }

    public Optional<User> saveUser(User user) {
        try {
            userRepository.save(user);
            return Optional.of(user);
        }catch (Exception e){
            log.error("Exception ",e);
            return Optional.empty();
        }
    }


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }
}
