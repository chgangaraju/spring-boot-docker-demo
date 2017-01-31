package org.springframework.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gancha on 31/1/17.
 */
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userRepository.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userRepository.findOne(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        List<User> userList = new ArrayList<>();
        allUsers.forEach(userList::add);
        return new ResponseEntity(allUsers, HttpStatus.OK);
    }


}
