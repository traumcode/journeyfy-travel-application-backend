package com.journeyfy.journeyfytravelapplication.components.wishes;


import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/wish-list")
@CrossOrigin
public class WishController {
    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final EntityRepository entityRepository;

    @PostMapping(path = "/add-wish")
    public void addWish(@RequestBody WishDto wish){
        Wish wish1 = new Wish();
        wish1.setUser(userRepository.findById(wish.getUserId()).get());
        wish1.setEntity(entityRepository.findById(wish.getActivityEntityId()).get());
        wish1.setName(wish.getName());
        wishRepository.save(wish1);

    }

    @GetMapping(path = "/all-wishes/{id}")
    public List<Wish> getAllWishesByUserId(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return wishRepository.getAllByUser(user);
    }

}
