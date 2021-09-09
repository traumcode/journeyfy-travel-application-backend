package com.journeyfy.journeyfytravelapplication.components.trips;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.journeyfy.journeyfytravelapplication.components.activityentity.Entity;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class TripDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("city_name")
    private String cityName;
    @JsonProperty("activity_entity_id")
    private Long activityEntityId;
    @JsonProperty("big_trip_name")
    private String bigTripName;

}
