package com.journeyfy.journeyfytravelapplication.activities;


import com.journeyfy.journeyfytravelapplication.museums.MuseumModel;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="activities", produces = "application/json")
public class ActivityController {
    public static List<ActivityModel> allActivities = Arrays.asList(
            new ActivityModel(1L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/a7/38/e5.jpg",
                    "Paris by Night",
                    "Our tour company is one of the original founding 2CV vintage car tours in Paris. We know our city inside out and most importantly the history of each monument and neighborhood. If you are looking for the safest, 75 - 85 percent of the city, we can not wait for you. We cater to groups of friends, couples and individual travelers. Tours are private and custom designed to suit your bucket list destinations. Consideration based on our knowledge of the city and avoidance in a tower where you do not learn a thing. Just check out our reviews!",
                    5,
                    160.14,
                    "Paris"
                    ),
            new ActivityModel(2L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/0b/05/3f/c5.jpg",
                    "Private Guided Tour on a Vintage Sidecar from 1 Hour to 7 Hour",
                    "You must try this Tour, this is the best way to visit the most amazing parts of Paris, avoiding traffic and stopping in all the big places in Paris.",
                    5,
                    107.85,
                    "Paris"
                    ),
            new ActivityModel(3L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/6e/4f/42.jpg",
                    "Lyon Highlights & Secrets Walking Guided Tour (small group) including Funicular",
                    "The best way to discover Lyon and a MUST DO to anyone visiting Europe. Brilliant and fun tours in small groups with the most charming, kowleadgeable and energetic guide. Sightseeing Lyon without doing this tour is about missing out so much.",
                    5,
                    38.99,
                    "Lyon"),
            new ActivityModel(4L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/93/7e/49.jpg",
                    "Valencia Bike Tour from the City to the Beach",
                    "The Bike Guy VLC is a fun and great way to bike around Valencia! ",
                    5,
                    35.18,
                    "Valencia"),
            new ActivityModel(5L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/70/3e/41.jpg",
                    "Barcelona Tapas, Taverns and History Tour",
                    "This is a fantastic way in, to discovering the world of Barcelona tapas as well as learning about the city's history, from its earliest times.",
                    5,
                    141.89,
                    "Barcelona"),
            new ActivityModel(6L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/72/91/20.jpg",
                    "Gaudi Bike Tour with Skip-the-Line Sagrada Familia Ticket",
                    "This was such a fun way to see Barcelona and many of Guadi's works around the city.",
                    4.5,
                    77.50,
                    "Barcelona"),
            new ActivityModel(7L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/6f/59/90.jpg",
                    "Skip the Line: Flamenco Night at Tablao Cordobes Ticket",
                    "Great small and intimate place with an amazing flamenco show!",
                    4,
                    52.46,
                    "Barcelona"
                    ),
            new ActivityModel(8L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/7b/29/58.jpg",
                    "Dark History Night Walking Tour in Barcelona",
                    "This is NOT a tour for those who wish to hide in the back of the group and scroll through your emails while half listening to the guide. You will be part of the narrative! You will be asked questions and you will hear some gory details from the treasure trove of Barcelona history!",
                    5,
                    22.66,
                    "Barcelona"),
            new ActivityModel(9L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/71/95/9a.jpg",
                    "Barcelona Highlights Tour and Montserrat Monastery with Hotel Pick-up",
                    "Great way to spend a good portion of the day when disembarking from the cruise terminal. I had no issues finding the guide and it was great that this company takes care of your luggage. You can spend the entire day seeing the sights of the city before hotel check in or a later flight to the airport. It would have been nice to spend a little more time in Montserrat, but the tour company wants the guests to see as much as possible. ",
                    5,
                    120.10,
                    "Barcelona"
                    ),
            new ActivityModel(10L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/6f/f1/23.jpg",
                    "Berlin Bike Tour",
                    "Really informative tour that took us to lots of interesting sites.",
                    5,
                    65.58,
                    "Berlin"),
            new ActivityModel(11L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/07/36/07/2c.jpg",
                    "Capital Dinner Cruise at Sunset with Sightseeing of Berlin",
                    "Nice and very friendly staff! Delicious food and excellent Italian wines!\n" +
                            "When visiting Berlin a must!",
                    4.5,
                    127.45,
                    "Berlin"
                    ),
            new ActivityModel(12L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/6f/0c/a7.jpg",
                    "Berlin Skip-the-Line Pergamon and New Museum Guided Tour Plus Museum Island Pass",
                    "There isn’t a better way to visit museum island than with an expert guide. ",
                    5,
                    70.35,
                    "Berlin"),
            new ActivityModel(13L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/75/b1/c7.jpg",
                    "Frankfurt 100-Minute Sightseeing Cruise",
                    "The boat tour starts at the Eiserner Steg. You can either sit upstairs outdoors or downstairs in the protected area. There is also food and drinks there.",
                    4,
                    16.45,
                    "Frankfurt"),
            new ActivityModel(14L,
                    "https://media-cdn.tripadvisor.com/media/attractions-splice-spp-720x480/06/75/b1/ca.jpg",
                    "Frankfurt 50-Minute Sightseeing Cruise",
                    "Very good all-round experience, especially given the glorious weather. Top deck is great for views and the bar service is not too expensive with efficient service.",
                    4,
                    12.88,
                    "Frankfurt")
    );

    @GetMapping(value = "/{cityName}")
    public List<ActivityModel> getAllActivitiesByCityName(@PathVariable("cityName") String cityName){
        return allActivities.stream().filter(activity -> activity.getCityName().equals(cityName)).collect(Collectors.toList());
    }

    @GetMapping(value = "/all-activities")
    public List<ActivityModel> getAllActivitiesByCityName(){
        return allActivities;
    }

    @GetMapping(value = "/top-activities")
    public List<ActivityModel> getTopMuseums(){
        return allActivities.stream().filter(activity -> activity.getRating()> 4.4).collect(Collectors.toList());
    }


}
