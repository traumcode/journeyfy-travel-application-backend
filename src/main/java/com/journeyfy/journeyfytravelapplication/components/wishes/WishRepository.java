package com.journeyfy.journeyfytravelapplication.components.wishes;


import com.journeyfy.journeyfytravelapplication.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface WishRepository extends JpaRepository<Wish, Long> {
    Set<Wish> getAllByUser(User user);
    boolean existsByEntityIdAndUserId(String entityId, Long userId);

    @Modifying
    @Query(value = "DELETE FROM wish WHERE activity_entity_id= :entityId AND user_id= :userId", nativeQuery = true)
    void deleteByEntityIdAndUserId(@Param("entityId") String entityId,
                                   @Param("userId") Long userId);

    Wish findByEntityIdAndUserId(String entityId, Long userId);
}
