package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.service.places.FindByCityService;
import pl.com.dariusz.giza.FindReviews.service.places.FindPlacesWithReviewsService;
import pl.com.dariusz.giza.FindReviews.service.places.PlacesService;
import pl.com.dariusz.giza.FindReviews.service.places.UpdatePlaceDetailsService;

import java.util.List;

@RestController
public class ReviewsController {

    private PlacesService placesService;
    private FindByCityService findByCityService;
    private FindPlacesWithReviewsService findPlacesWithReviewsService;
    private UpdatePlaceDetailsService updatePlaceDetailsService;

    @Autowired
    public ReviewsController(PlacesService placesService, FindByCityService findByCityService,
                             FindPlacesWithReviewsService findPlacesWithReviewsService, UpdatePlaceDetailsService updatePlaceDetailsService) {
        this.placesService = placesService;
        this.findByCityService = findByCityService;
        this.findPlacesWithReviewsService = findPlacesWithReviewsService;
        this.updatePlaceDetailsService = updatePlaceDetailsService;
    }

    @GetMapping("/api/getAll")
    public List<Places> getAll() {
        return placesService.getAll();
    }

    @GetMapping("/api/getByCity")
    public List<Places> getByCity(@RequestParam String city) {
        return findByCityService.findByCity(city);
    }

    @GetMapping("/api/getPlacesWithReviews")
    public List<Places> getWithReviews() {
        return findPlacesWithReviewsService.findPlacesWithReviews();
    }

    @PostMapping("/addPlaces")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Places> addPlacesList(@RequestBody List<Places> placesList) {
        Preconditions.checkNotNull(placesList);
        return placesService.save(placesList);

    }

    @PutMapping("/api/updatePlace")
    @ResponseStatus(HttpStatus.OK)
    public Places update(@RequestParam String id, @RequestBody Places place){
        Preconditions.checkNotNull(id,place);
        return updatePlaceDetailsService.update(id, place);
    }

    @DeleteMapping("/deletePlaceById")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlaceById(@RequestParam String id) {
        Preconditions.checkNotNull(id);
        placesService.delete(id);
    }
}
