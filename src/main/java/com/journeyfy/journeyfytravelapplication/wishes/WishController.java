package com.journeyfy.journeyfytravelapplication.wishes;


import com.journeyfy.journeyfytravelapplication.activities.ActivityRepository;
import com.journeyfy.journeyfytravelapplication.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.clubs.ClubRepository;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.hotels.HotelRepository;
import com.journeyfy.journeyfytravelapplication.museums.MuseumRepository;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

}
