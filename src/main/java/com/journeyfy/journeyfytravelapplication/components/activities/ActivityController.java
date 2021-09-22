package com.journeyfy.journeyfytravelapplication.components.activities;


import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import com.journeyfy.journeyfytravelapplication.components.hotels.Hotel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="activities", produces = "application/json")
@AllArgsConstructor
@Slf4j
public class ActivityController {
    private final ActivityRepository activityRepository;

    @GetMapping(value = "/{cityName}")
    public List<Activity> getAllActivitiesByCityName(@PathVariable("cityName") String cityName){
        return activityRepository.getActivitiesByCityNameAndActivityType(cityName, ActivityType.ACTIVITY);
    }

    @GetMapping(value = "/all-activities")
    public List<Activity> getAllActivities(){
        return activityRepository.getActivitiesByActivityType(ActivityType.ACTIVITY);
    }

    @GetMapping(value = "/top-activities")
    public List<Activity> getTopMuseums(){
        return activityRepository.getActivitiesByActivityTypeAndRatingGreaterThan(ActivityType.ACTIVITY, 4d);
    }

    @PostMapping("/add-activity")
    public ResponseEntity<Activity> addActivity(@RequestBody @Valid Activity activity) {
        if(!activityRepository.existsByName(activity.getName())) {
            Activity activity1 = new Activity();
            activity1.setId(activity.getId());
            activity1.setName(activity.getName());
            activity1.setPictureLink(activity.getPictureLink());
            activity1.setRating(activity.getRating());
            activity1.setCityName(activity.getCityName());
            activity1.setActivityType(activity.getActivityType());
            activityRepository.save(activity1);
            log.info(String.valueOf(activity1));
            return ResponseEntity.ok(activity1);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
