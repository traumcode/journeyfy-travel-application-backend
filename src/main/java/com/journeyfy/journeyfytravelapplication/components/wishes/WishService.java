package com.journeyfy.journeyfytravelapplication.components.wishes;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class WishService {
    private final WishRepository wishRepository;

    public Wish findByEntityIdAndUserId(String entityId, Long userId) {
        log.info("intra");
        return wishRepository.findByEntityIdAndUserId(entityId, userId);
    }
}
