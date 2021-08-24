package com.journeyfy.journeyfytravelapplication.clubs;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Long> {
    List<Club> getClubsByCityName(String cityName);
    List<Club> getClubsByRatingGreaterThan(double rating);
}
