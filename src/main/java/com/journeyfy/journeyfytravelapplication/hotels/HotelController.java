package com.journeyfy.journeyfytravelapplication.hotels;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "hotels", produces = "application/json")
@AllArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping(value = "/{cityName}")
    public List<Hotel> getAllHotels(@PathVariable("cityName") String cityName) {
       return hotelService.getAllHotelsByCityName(cityName);
    }
  
     @GetMapping(value = "/top-hotels")
    public List<Hotel> getTopHotels() {
        return hotelRepository.getHotelsByRatingGreaterThan(4d);
    }

}

