package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;
import pl.com.dariusz.giza.FindReviews.service.places.FindByCity;
import pl.com.dariusz.giza.FindReviews.service.places.FindPlacesWithReviews;
import pl.com.dariusz.giza.FindReviews.service.places.UpdatePlaceDetails;

import java.util.List;

@RestController
public class ReviewsController {

    private PlacesRepository placesRepository;
    private FindByCity findByCity;
    private FindPlacesWithReviews findPlacesWithReviews;
    private UpdatePlaceDetails updatePlaceDetails;

    @Autowired
    public ReviewsController(PlacesRepository placesRepository, FindByCity findByCity,
                             FindPlacesWithReviews findPlacesWithReviews, UpdatePlaceDetails updatePlaceDetails) {
        this.placesRepository = placesRepository;
        this.findByCity = findByCity;
        this.findPlacesWithReviews = findPlacesWithReviews;
        this.updatePlaceDetails = updatePlaceDetails;
    }

    @GetMapping("/api/getAll")
    public List<Places> getAll() {
        return placesRepository.findAll();
    }

    @GetMapping("/api/getByCity")
    public List<Places> getByCity(@RequestParam String city) {
        return findByCity.findByCity(city);
    }

    @GetMapping("/api/getPlacesWithReviews")
    public List<Places> getWithReviews() {
        return findPlacesWithReviews.findPlacesWithReviews();
    }

    @PostMapping("/addPlaces")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Places> addPlacesList(@RequestBody List<Places> placesList) {
        Preconditions.checkNotNull(placesList);
        return placesRepository.saveAll(placesList);
    }

    @PutMapping("/api/updatePlace")
    @ResponseStatus(HttpStatus.OK)
    public Places update(@RequestParam String id, @RequestBody Places place){
        Preconditions.checkNotNull(id,place);
        return updatePlaceDetails.update(id,place);
    }

    @DeleteMapping("/deletePlaceById")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlaceById(@RequestParam String id) {
        Preconditions.checkNotNull(id);
        placesRepository.deleteById(id);
    }
}
