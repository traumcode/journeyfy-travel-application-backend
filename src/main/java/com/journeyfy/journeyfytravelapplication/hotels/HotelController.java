package com.journeyfy.journeyfytravelapplication.hotels;

import lombok.AllArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
        if (hotelRepository.findByName(hotel.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This name already exists");
        }
        hotelRepository.save(hotel);
    }

    @PutMapping("/{id}/edit-hotel")
    public void editHotel(@RequestBody Hotel hotel, @PathVariable Long id) {
        if (hotelRepository.findByName(hotel.getName()) != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This name already exists");
        } else {
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

    @DeleteMapping("/{id}/delete-hotel")
    public void deleteHotel(@PathVariable Long id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        if(hotel.isPresent()) {
            hotelRepository.delete(hotel.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This hotel doesn't exist");
        }
    }
}

