package com.journeyfy.journeyfytravelapplication.wishes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.journeyfy.journeyfytravelapplication.activities.Activity;
import com.journeyfy.journeyfytravelapplication.clubs.Club;
import com.journeyfy.journeyfytravelapplication.hotels.Hotel;
import com.journeyfy.journeyfytravelapplication.museums.Museum;
import com.journeyfy.journeyfytravelapplication.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "wish")
public class Wish {
    @Id
    @SequenceGenerator(name = "wish_sequence", sequenceName = "wish_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wish_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne()
    @JoinColumn(name = "activity_id")
    @JsonIgnore
    private Activity activity;

    @ManyToOne()
    @JoinColumn(name = "club_id")
    @JsonIgnore
    private Club club;

    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    @ManyToOne()
    @JoinColumn(name = "museum_id")
    @JsonIgnore
    private Museum museum;
}
