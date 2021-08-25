package com.journeyfy.journeyfytravelapplication.hotels;

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

    @GetMapping(value = "/{cityName}")
    public List<Hotel> getAllHotels(@PathVariable("cityName") String cityName) {
        return hotelRepository.getHotelsByCityName(cityName);
    }

    @GetMapping(value = "/top-hotels")
    public List<Hotel> getTopHotels() {
        return hotelRepository.getHotelsByRatingGreaterThan(4d);
    }

    @PostMapping("/add-hotel")
    public void addHotel(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @PutMapping("/{id}/edit-hotel")
    public void editHotel(@RequestBody Hotel hotel, @PathVariable Long id) {
        Hotel hotel1 = hotelRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Couldn't find that show id " + id));
        hotel1.setName(hotel.getName());
        hotel1.setHotelClass(hotel.getHotelClass());
        hotel1.setCityName(hotel.getCityName());
        hotel1.setDescription(hotel.getDescription());
        hotel1.setPicture(hotel.getPicture());
        hotel1.setPrice(hotel.getPrice());
        hotel1.setRating(hotel.getRating());
        hotel1.setSiteAddress(hotel.getSiteAddress());
        hotelRepository.save(hotel1);
    }

}

