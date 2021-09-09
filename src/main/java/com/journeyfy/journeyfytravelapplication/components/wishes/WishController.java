package com.journeyfy.journeyfytravelapplication.components.wishes;


import com.journeyfy.journeyfytravelapplication.advice.ErrorMessage;
import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/wish-list")
@CrossOrigin
@Slf4j
public class WishController {
    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final EntityRepository entityRepository;

    @PostMapping(path = "/add-wish")
    public ResponseEntity<?> addWish(@RequestBody WishDto wish){
        Wish wish1 = new Wish();
        wish1.setUser(userRepository.findById(wish.getUserId()).get());
        wish1.setEntity(entityRepository.findById(wish.getActivityEntityId()).get());
        wish1.setName(wish.getName());
        if(!wishRepository.existsByEntityIdAndUserId(wish.getActivityEntityId(), userRepository.findById(wish.getUserId()).get().getId())) {
            wishRepository.save(wish1);
            return ResponseEntity.ok("Wish added to your wishlist");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(path = "/all-wishes/{id}")
    public Set<Wish> getAllWishesByUserId(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return wishRepository.getAllByUser(user);
    }


    @DeleteMapping(path = "/remove/{wishId}")
    public ResponseEntity<?> deleteWishById(@PathVariable(name = "wishId") Long wishId) {
        wishRepository.deleteById(wishId);
        return ResponseEntity.ok("Wish with id " + wishId + " was deleted");
    }


}
