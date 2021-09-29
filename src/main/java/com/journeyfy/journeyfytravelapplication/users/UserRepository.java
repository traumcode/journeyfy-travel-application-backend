package com.journeyfy.journeyfytravelapplication.users;

import com.journeyfy.journeyfytravelapplication.components.trips.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);
    User findUserByUsername(String username);
    User findUserByEmail(String email);
    User findUserById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    boolean existsById(Long id);


}
