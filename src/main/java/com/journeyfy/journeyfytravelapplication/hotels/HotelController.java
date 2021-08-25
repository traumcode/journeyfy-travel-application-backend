package com.journeyfy.journeyfytravelapplication.hotels;

import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "hotels", produces = "application/json")
@AllArgsConstructor
public class HotelController {
    private final HotelRepository hotelRepository;

    @GetMapping(value = "/all-hotels")
    public List<Hotel> getAllHotels(){
        return hotelRepository.getHotelsByActivityType(ActivityType.HOTEL);
    }

    @GetMapping(value = "/{cityName}")
    public List<Hotel> getAllHotelsByCityName(@PathVariable("cityName") String cityName) {
        return hotelRepository.getHotelsByCityNameAndActivityType(cityName, ActivityType.HOTEL);
    }

    @GetMapping(value = "/top-hotels")
    public List<Hotel> getTopHotels() {
        return hotelRepository.getHotelsByActivityTypeAndRatingGreaterThan(ActivityType.HOTEL, 4d);
    }

    @PostMapping("/add-hotel")
    public void addHotel(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
    }



}

