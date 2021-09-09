package com.journeyfy.journeyfytravelapplication.components.wishes;


import com.journeyfy.journeyfytravelapplication.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
    Wish findWishByName(String name);
    Set<Wish> getAllByUser(User user);
    boolean existsByEntityIdAndUserId(Long entityId, Long userId);
}
