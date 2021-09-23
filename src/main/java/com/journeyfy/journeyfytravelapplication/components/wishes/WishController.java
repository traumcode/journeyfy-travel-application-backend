package com.journeyfy.journeyfytravelapplication.components.wishes;
import com.journeyfy.journeyfytravelapplication.components.activityentity.EntityRepository;
import com.journeyfy.journeyfytravelapplication.users.User;
import com.journeyfy.journeyfytravelapplication.users.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "/wish-list")
@CrossOrigin
@Slf4j
public class WishController {
    private final WishRepository wishRepository;
    private final UserRepository userRepository;
    private final EntityRepository entityRepository;
    private final WishService wishService;

    @PostMapping(path = "/add-wish")
    public ResponseEntity<?> addWish(@RequestBody WishDto wish){
        Wish wish1 = new Wish();
        log.info(String.valueOf(wish));
        wish1.setUser(userRepository.findById(wish.getUserId()).get());
        log.info(String.valueOf(wish.getActivityEntityId()));
        wish1.setEntity(entityRepository.findById(wish.getActivityEntityId()).get());
        wish1.setName(wish.getName());

        if(!wishRepository.existsByEntityIdAndUserId(wish.getActivityEntityId(), userRepository.findById(wish.getUserId()).get().getId())) {
            wishRepository.save(wish1);
            return ResponseEntity.ok("Wish added to your wishlist");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping(path = "/all-wishes/{id}")
    public List<Wish> getAllWishesByUserId(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        List<Wish> wishes = wishRepository.getAllByUser(user);
        return wishes;
    }


    @DeleteMapping(path = "/remove/{entityId}/{userId}")
    @Transactional
    public ResponseEntity<?> deleteWishById(@PathVariable(name = "entityId") String entityId, @PathVariable(name = "userId") Long userId) {
        wishRepository.deleteByEntityIdAndUserId(entityId, userId);
        return ResponseEntity.ok("Wish with id " + entityId + " was deleted");
    }
}
