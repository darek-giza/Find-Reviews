package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.service.FindByCityService;
import pl.com.dariusz.giza.FindReviews.service.FindPlacesWithReviewsService;
import pl.com.dariusz.giza.FindReviews.service.PlacesService;
import pl.com.dariusz.giza.FindReviews.service.UpdatePlaceDetailsService;

import java.util.List;

@RestController
public class PlacesController {

    private PlacesService placesService;
    private FindByCityService findByCityService;
    private FindPlacesWithReviewsService findPlacesWithReviewsService;
    private UpdatePlaceDetailsService updatePlaceDetailsService;

    @Autowired
    public PlacesController(PlacesService placesService, FindByCityService findByCityService,
                            FindPlacesWithReviewsService findPlacesWithReviewsService, UpdatePlaceDetailsService updatePlaceDetailsService) {
        this.placesService = placesService;
        this.findByCityService = findByCityService;
        this.findPlacesWithReviewsService = findPlacesWithReviewsService;
        this.updatePlaceDetailsService = updatePlaceDetailsService;
    }

    @GetMapping("/api/getAll")
    public ResponseEntity<List<Places>> getAll() {
        final List<Places> all = placesService.getAll();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("/api/getByCity")
    public ResponseEntity<List<Places>> getByCity(@RequestParam String city) {
        List<Places> list = findByCityService.findByCity(city);
        if(list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
            return new ResponseEntity<>(list, HttpStatus.OK);

     }

    @GetMapping("/api/getPlacesWithReviews")
    public ResponseEntity<List<Places>> getWithReviews() {
        final List<Places> placesWithReviews = findPlacesWithReviewsService.findPlacesWithReviews();
        if(placesWithReviews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(placesWithReviews,HttpStatus.OK);
    }

    @PostMapping("/api/addPlaces")
    public ResponseEntity<List<Places>> addPlacesList(@RequestBody List<Places> placesList) {
        Preconditions.checkNotNull(placesList);
        final List<Places> saveList = placesService.save(placesList);
        if(placesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saveList,HttpStatus.CREATED);

    }

    @PutMapping("/api/updatePlace")
    public ResponseEntity<Places> update(@RequestParam String id, @RequestBody Places place){
        Preconditions.checkNotNull(id,place);
        final Places update = updatePlaceDetailsService.update(id, place);
        if(id==null || place==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("/api/deletePlaceById")
    public ResponseEntity deletePlaceById(@RequestParam String id) {
        Preconditions.checkNotNull(id);
        if (id == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        final Places placeById = placesService.getById(id);
        if (placeById == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            placesService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }
}
