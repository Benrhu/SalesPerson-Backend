package com.grouzy.Backend.Controllers;

import com.grouzy.Backend.Entities.User;
import com.grouzy.Backend.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private UserRepository userRepo;
    private final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserRepository userRepo){
        this.userRepo = userRepo;
    }

    @GetMapping("/api/users")
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> findOneById(@PathVariable Long userId) {
        Optional<User> userOpt = userRepo.findById(userId);
        if (userOpt.isPresent())
            return ResponseEntity.ok(userOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("api/users")
    public ResponseEntity<User> create(@RequestBody User user, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        if(user.getUserId() != null){
            log.warn("Trying to create a user with id");
            System.out.println("Trying to create a user with id");
            return ResponseEntity.badRequest().build();
        }
        User result = userRepo.save(user);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/api/users")
    public ResponseEntity<User> update(@RequestBody User user){
        if(user.getUserId() == null ){
            log.warn("Trying to update a non existent user");
            return ResponseEntity.badRequest().build();
        }
        if(!userRepo.existsById(user.getUserId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }

        User result = userRepo.save(user);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/api/users")
    public ResponseEntity<User> delete(@PathVariable Long userId){
        if (!userRepo.existsById(userId)) {
            log.warn("Trying to delete a non existent user");
            return ResponseEntity.notFound().build();
        }
        userRepo.deleteById(userId);
        return ResponseEntity.ok().build();
    }
}
