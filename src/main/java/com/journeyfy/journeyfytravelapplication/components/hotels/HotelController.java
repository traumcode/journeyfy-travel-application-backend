package com.journeyfy.journeyfytravelapplication.components.hotels;

import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "hotels", produces = "application/json")
@AllArgsConstructor
@Slf4j
public class HotelController {
    private final HotelRepository hotelRepository;
    private final EntityRepository entityRepository;

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
    public ResponseEntity<Hotel> addHotel(@RequestBody @Valid Hotel hotel) {
        if(!hotelRepository.existsByName(hotel.getName())) {
            hotelRepository.save(hotel);
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/last")
    public ResponseEntity<Hotel> getLastHotel() {
        Hotel hotel = (Hotel) entityRepository.getLastEntity();
        return ResponseEntity.ok(hotel);
    }



}

