package com.journeyfy.journeyfytravelapplication.components.trips;

import com.journeyfy.journeyfytravelapplication.components.activities.Activity;
import com.journeyfy.journeyfytravelapplication.components.activities.ActivityRepository;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.components.clubs.Club;
import com.journeyfy.journeyfytravelapplication.components.clubs.ClubRepository;
import com.journeyfy.journeyfytravelapplication.components.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.components.hotels.HotelRepository;
import com.journeyfy.journeyfytravelapplication.components.museums.Museum;
import com.journeyfy.journeyfytravelapplication.components.museums.MuseumRepository;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/trip")
public class TripController {
    private TripRepository tripRepository;
    private final UserRepository userRepository;
    private final EntityRepository entityRepository;
    private final MuseumRepository museumRepository;
    private final ClubRepository clubRepository;
    private final HotelRepository hotelRepository;
    private final ActivityRepository activityRepository;


    @PostMapping("/add-trip/{userId}")
    private ResponseEntity<?> addTrip(@PathVariable(value = "userId") Long userId,
                                      @RequestBody TripDto tripDto,
                                      @RequestParam double budget,
                                      @RequestParam String name) {

        // system creates a list of entities for a trip
        List<Entity> entities = entityRepository.getAllByCityNameAndOrderByPriceAsc(tripDto.getCityName());
        List<Hotel> hotels = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Hotel) {
                hotels.add((Hotel) entity);
            }
        }
        List<Museum> museums = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Museum) {
                museums.add((Museum) entity);
            }
        }
        List<Club> clubs = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Club) {
                clubs.add((Club) entity);
            }
        }
        List<Activity> activities = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Activity) {
                activities.add((Activity) entity);
            }
        }
        Random random = new Random();
        Set<Entity> userTrip = new HashSet<>();
        Club randomClub = clubs.get(random.nextInt(clubs.size()));
        userTrip.add(randomClub);

        double remainingBudget = 0;

        while (budget >= 100) {
            Activity randomActivity = activities.get(random.nextInt(activities.size()));
            if (budget - randomActivity.getPrice() > 0) {
                userTrip.add(randomActivity);
                budget -= randomActivity.getPrice();
                log.info(String.valueOf(budget));
            }
            Hotel randomHotel = hotels.get(random.nextInt(hotels.size()));
            if (budget - randomHotel.getPrice() > 0) {
                userTrip.add(randomHotel);
                budget -= randomHotel.getPrice();
                log.info(String.valueOf(budget));
            }
            Museum randomMuseum = museums.get(random.nextInt(museums.size()));
            if (budget - randomMuseum.getPrice() > 0) {
                userTrip.add(randomMuseum);
                budget -= randomMuseum.getPrice();
                log.info(String.valueOf(budget));
            }
            remainingBudget = budget;
        }
        User user = userRepository.getById(userId);

        for (Entity entity : userTrip) {
            Trip trip = new Trip();
            trip.setCityName(entity.getCityName());
            trip.setBudget(remainingBudget);
            trip.setEntity(entity);
            trip.setName(name);
            user.addTrip(trip);
            tripRepository.save(trip);
        }
        log.info(String.valueOf(userTrip));
        log.info(String.valueOf(budget));

        return new ResponseEntity<>(userTrip, HttpStatus.OK);
    }

    @GetMapping("/get-trips-by-name")
    public List<List<Trip>> getTripsByName() {
        List<String> names = tripRepository.getDistinctByName();
        log.info(String.valueOf(names));
        List<List<Trip>> list = new ArrayList<>();
        for(String name : names) {
            list.add(tripRepository.getAllByName(name));
        }

        return list;
    }

    @DeleteMapping("/delete/{tripId}")
    public void deleteTrip(@PathVariable(value = "tripId") Long tripId) {
        tripRepository.delete(tripRepository.getById(tripId));
    }

}


