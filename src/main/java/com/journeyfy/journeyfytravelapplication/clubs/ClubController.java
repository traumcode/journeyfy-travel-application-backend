package com.journeyfy.journeyfytravelapplication.clubs;


import com.journeyfy.journeyfytravelapplication.enums.ActivityType;
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
        return clubRepository.getClubsByCityNameAndActivityType(cityName, ActivityType.CLUB);
    }

    @GetMapping(value = "/all-clubs")
    public List<Club> getAllClubs(){
        return clubRepository.getClubsByActivityType(ActivityType.CLUB);
    }

    @GetMapping(value = "/top-clubs")
    public List<Club> getTopClubs(){
        return clubRepository.getClubsByActivityTypeAndRatingGreaterThan(ActivityType.CLUB, 4d);
    }

}
