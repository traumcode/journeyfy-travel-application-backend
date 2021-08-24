package com.journeyfy.journeyfytravelapplication.clubs;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "clubs", produces = "application/json")
@AllArgsConstructor
public class ClubController {
    private final ClubRepository clubRepository;

    @GetMapping(value = "/{cityName}")
    public List<Club> getAllClubsByCityName(@PathVariable("cityName") String cityName) {
        return clubRepository.getClubsByCityName(cityName);
    }

    @GetMapping(value = "/all-clubs")
    public List<Club> getAllActivitiesByCityName(){
        return clubRepository.findAll();
    }

    @GetMapping(value = "/top-clubs")
    public List<Club> getTopMuseums(){
        return clubRepository.getClubsByRatingGreaterThan(4d);
    }
}
