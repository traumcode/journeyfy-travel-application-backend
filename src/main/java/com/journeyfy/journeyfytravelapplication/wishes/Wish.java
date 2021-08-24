package com.journeyfy.journeyfytravelapplication.wishes;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String name;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "wish")
    @JsonManagedReference
    private List<Activity> activities;
    @OneToMany(mappedBy = "wish")
    @JsonManagedReference
    private List<Club> clubs;
    @OneToMany(mappedBy = "wish")
    @JsonManagedReference
    private List<Hotel> hotels;
    @OneToMany(mappedBy = "wish")
    @JsonManagedReference
    private List<Museum> museums;
}
