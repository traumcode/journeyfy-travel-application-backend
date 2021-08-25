package com.journeyfy.journeyfytravelapplication.wishes;


import com.journeyfy.journeyfytravelapplication.activities.ActivityRepository;
import com.journeyfy.journeyfytravelapplication.clubs.ClubRepository;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.hotels.HotelRepository;
import com.journeyfy.journeyfytravelapplication.museums.MuseumRepository;
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


    @PostMapping(path = "/add-wish")
    public void addWish(@RequestBody Wish wish){
        if(wishRepository.findWishByName(wish.getName())!= null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This wish already exist");
        }else{
            wishRepository.save(wish);
        }
    }

}
