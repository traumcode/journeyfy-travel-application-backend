package com.journeyfy.journeyfytravelapplication.security.repositories;

import com.journeyfy.journeyfytravelapplication.security.models.RefreshToken;
import com.journeyfy.journeyfytravelapplication.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    @Override
    Optional<RefreshToken> findById(Long id);

    Optional<RefreshToken> findByToken(String token);

    @Modifying
    int deleteByUser(User user);

}
