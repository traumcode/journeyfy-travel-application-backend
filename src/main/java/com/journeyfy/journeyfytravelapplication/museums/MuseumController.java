package com.journeyfy.journeyfytravelapplication.museums;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path="museums", produces = "application/json")
@AllArgsConstructor
public class MuseumController {
    private final MuseumRepository museumRepository;

    @GetMapping(value= "/{cityName}")
    public List<Museum> getAllMuseums(@PathVariable("cityName") String cityName){
        return museumRepository.getMuseumsByCityName(cityName);
    }

    @GetMapping(value = "/top-museums")
    public List<Museum> getTopMuseums(){
        return museumRepository.getMuseumsByRatingGreaterThan(4d);
    }

    @PostMapping(path = "/add")
    public void addMuseum(@RequestBody Museum museum){
        System.out.println(museumRepository.findByName(museum.getName()));
        if(museumRepository.findByName(museum.getName()) != null){
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
            if(museumRepository.findByName(museum.getName()) != null){
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