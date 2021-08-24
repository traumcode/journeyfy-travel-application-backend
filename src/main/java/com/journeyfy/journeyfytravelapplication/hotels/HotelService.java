package com.journeyfy.journeyfytravelapplication.hotels;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotelsByCityName(String cityName) {
        return hotelRepository.getAllByCityName(cityName);
    }
}
