//package com.journeyfy.journeyfytravelapplication.security.services;
//
//
//import com.journeyfy.journeyfytravelapplication.exception.TokenRefreshException;
//import com.journeyfy.journeyfytravelapplication.security.models.RefreshToken;
//import com.journeyfy.journeyfytravelapplication.security.repositories.RefreshTokenRepository;
//import com.journeyfy.journeyfytravelapplication.users.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.time.Instant;
//import java.util.Optional;
//import java.util.UUID;
//
//@Service
//public class RefreshTokenService {
//
//    @Value("${journeyfy.app.jwtRefreshExpirationMs}")
//    private Long refreshTokenDurationMs;
//    @Autowired
//    private RefreshTokenRepository refreshTokenRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    public Optional<RefreshToken> findByToken(String token) {
//        return refreshTokenRepository.findByToken(token);
//    }
//
//    public RefreshToken createRefreshToken(Long userId) {
//        Optional<RefreshToken> existingToken = refreshTokenRepository.findByUserId(userId);
//        if(Instant.now().compareTo(existingToken.get().getExpiryDate()) < 0) {
//            RefreshToken refreshToken = new RefreshToken();
//            refreshToken.setUser(userRepository.findById(userId).get());
//            refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
//            refreshToken.setToken(UUID.randomUUID().toString());
//            refreshToken = refreshTokenRepository.save(refreshToken);
//            return refreshToken;
//        } else {
//            return existingToken.get();
//        }
//    }
//
//    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
//        if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
//            refreshTokenRepository.delete(refreshToken);
//            throw new TokenRefreshException(refreshToken.getToken(), "Refresh token was expired, please make a new sign in request");
//        }
//        return refreshToken;
//    }
//
//    @Transactional
//    public int deleteByUserId(Long userId) {
//        return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
//    }
//
//}
