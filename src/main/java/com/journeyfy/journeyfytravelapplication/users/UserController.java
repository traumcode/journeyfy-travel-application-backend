package com.journeyfy.journeyfytravelapplication.users;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    private final UserRepository userRepository;

    @DeleteMapping(path = "/{id}/delete")
    public void deleteUserById(@PathVariable(value = "id") Long id){
        userRepository.delete(userRepository.getById(id));
    }

    @GetMapping(path = "/all-users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
       return userRepository.findById(id).get();
    }


    @PostMapping(path="/login")
    public User findUser(@RequestBody User user) {
        if(userRepository.getUserByUserNameAndPassword(user.getUsername(), user.getPassword()) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userRepository.getUserByUserNameAndPassword(user.getUsername(), user.getPassword());
    }


    @PostMapping(path = "/add-user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
}
