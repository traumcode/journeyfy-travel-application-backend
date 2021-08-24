package com.journeyfy.journeyfytravelapplication.activities;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="activities", produces = "application/json")
@AllArgsConstructor
public class ActivityController {
    private final ActivityRepository activityRepository;

    @GetMapping(value = "/{cityName}")
    public List<Activity> getAllActivitiesByCityName(@PathVariable("cityName") String cityName){
        return activityRepository.getActivitiesByCityName(cityName);
    }

    @GetMapping(value = "/all-activities")
    public List<Activity> getAllActivitiesByCityName(){
        return activityRepository.findAll();
    }

    @GetMapping(value = "/top-activities")
    public List<Activity> getTopMuseums(){
        return activityRepository.getActivitiesByRatingGreaterThan(4d);
    }


}
