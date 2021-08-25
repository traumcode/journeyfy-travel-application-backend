package com.journeyfy.journeyfytravelapplication.wishes;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
    Wish findWishByName(String name);
}
