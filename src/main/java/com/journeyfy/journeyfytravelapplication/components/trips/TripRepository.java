package com.journeyfy.journeyfytravelapplication.components.trips;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    List<Trip> getAllByName(String name);

    @Query(value = "SELECT DISTINCT name FROM trip", nativeQuery = true)
    List<String> getDistinctByName();


}
