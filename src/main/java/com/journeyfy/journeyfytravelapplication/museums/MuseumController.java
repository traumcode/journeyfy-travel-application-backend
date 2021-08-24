package com.journeyfy.journeyfytravelapplication.museums;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="museums", produces = "application/json")
@AllArgsConstructor
public class MuseumController {
    private final MuseumRepository museumRepository;

    @GetMapping(value= "/{cityName}")
    public List<Museum> getAllMuseums(@PathVariable("cityName") String cityName){
        return museumRepository.getMuseumsByCityName(cityName);
    }

    @GetMapping(value = "/top-museums")
    public List<Museum> getTopMuseums(){
        return museumRepository.getMuseumsByRatingGreaterThan(4d);
    }
}