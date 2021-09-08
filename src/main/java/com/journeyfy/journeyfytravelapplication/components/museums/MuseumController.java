package com.journeyfy.journeyfytravelapplication.components.museums;


import com.journeyfy.journeyfytravelapplication.components.enums.ActivityType;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="museums", produces = "application/json")
@AllArgsConstructor
public class MuseumController {
    private final MuseumRepository museumRepository;

    @GetMapping(value= "/{cityName}")
    public List<Museum> getAllMuseums(@PathVariable("cityName") String cityName){
        return museumRepository.getMuseumsByCityNameAndActivityType(cityName, ActivityType.MUSEUM);
    }

    @GetMapping(value = "/top-museums")
    public List<Museum> getTopMuseums(){
        return museumRepository.getMuseumsByActivityTypeAndRatingGreaterThan(ActivityType.MUSEUM, 4d);
    }

    @PostMapping(path = "/add")
    public void addMuseum(@RequestBody Museum museum){
        System.out.println(museumRepository.findByNameAndActivityType(museum.getName(), ActivityType.MUSEUM));
        if(museumRepository.findByNameAndActivityType(museum.getName(), ActivityType.MUSEUM) != null){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This hotel name already exist in database");
        }else{
            museumRepository.save(museum);
        }
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteMuseum(@PathVariable("id") Long id){
        museumRepository.delete(museumRepository.getById(id));
    }

    @PutMapping(path = "/edit/{id}")
    public void editMuseumById(@PathVariable("id") Long id, @RequestBody Museum museum){
        Optional<Museum> foundedMuseum = museumRepository.findById(id);
        if(foundedMuseum.isPresent()){
            if(museumRepository.findByNameAndActivityType(museum.getName(), ActivityType.MUSEUM) != null){
                foundedMuseum.get().setPictureLink(museum.getPictureLink());
                foundedMuseum.get().setName(museum.getName());
                foundedMuseum.get().setDescription(museum.getDescription());
                foundedMuseum.get().setRating(museum.getRating());
                foundedMuseum.get().setPrice(museum.getPrice());
                foundedMuseum.get().setCityName(museum.getCityName());
                foundedMuseum.get().setSiteLink(museum.getSiteLink());
                museumRepository.save(foundedMuseum.get());
            }

        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
    }



}