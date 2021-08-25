package com.journeyfy.journeyfytravelapplication.users;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")
@AllArgsConstructor
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

    @PostMapping(path = "/add-user")
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }
}
