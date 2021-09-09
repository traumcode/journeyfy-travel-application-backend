package com.journeyfy.journeyfytravelapplication.components.activityentity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EntityRepository extends JpaRepository<Entity, Long> {

    List<Entity> getAllByCityName(String cityName);
    @Query(value = "SELECT * FROM entity WHERE city_name = cast(?1 as text) ORDER BY price ASC", nativeQuery = true)
    List<Entity> getAllByCityNameAndOrderByPriceAsc(String cityName);



}
