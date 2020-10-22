package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.com.dariusz.giza.FindReviews.dto.PlaceDto;
import pl.com.dariusz.giza.FindReviews.mapper.PlaceMapper;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.service.FindByCityService;
import pl.com.dariusz.giza.FindReviews.service.FindPlacesWithReviewsService;
import pl.com.dariusz.giza.FindReviews.service.PlacesService;
import pl.com.dariusz.giza.FindReviews.service.UpdatePlaceDetailsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(PlacesController.BASE_URL)
public class PlacesController {

    public static final String BASE_URL = "/api";

    private PlacesService placesService;
    private FindByCityService findByCityService;
    private FindPlacesWithReviewsService findPlacesWithReviewsService;
    private UpdatePlaceDetailsService updatePlaceDetailsService;
    private PlaceMapper placeMapper;

    @Autowired
    public PlacesController(PlacesService placesService, FindByCityService findByCityService,
                            FindPlacesWithReviewsService findPlacesWithReviewsService,
                            UpdatePlaceDetailsService updatePlaceDetailsService, PlaceMapper placeMapper) {
        this.placesService = placesService;
        this.findByCityService = findByCityService;
        this.findPlacesWithReviewsService = findPlacesWithReviewsService;
        this.updatePlaceDetailsService = updatePlaceDetailsService;
        this.placeMapper = placeMapper;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Places>> getAll() {
        final List<Places> all = placesService.getAll();
        if(all.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(all,HttpStatus.OK);
    }

    @GetMapping("getByCity")
    public ResponseEntity<List<PlaceDto>> getByCity(@RequestParam String city) {
        List<Places> list = findByCityService.findByCity(city);
        if (list == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<PlaceDto> placeDtoListDto = list.stream()
                .map(p -> placeMapper.convertPlaceToDto(p))
                .collect(Collectors.toList());

        return new ResponseEntity<>(placeDtoListDto, HttpStatus.OK);
    }

    @GetMapping("getPlacesWithReviews")
    public ResponseEntity<List<Places>> getWithReviews() {
        final List<Places> placesWithReviews = findPlacesWithReviewsService.findPlacesWithReviews();
        if(placesWithReviews.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(placesWithReviews,HttpStatus.OK);
    }

    @PostMapping("/addPlaces")
    public ResponseEntity<List<Places>> addPlacesList(@RequestBody List<Places> placesList) {
        Preconditions.checkNotNull(placesList);
        final List<Places> saveList = placesService.save(placesList);
        if(placesList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(saveList,HttpStatus.CREATED);
    }

    @PutMapping("updatePlace")
    public ResponseEntity<Places> update(@RequestParam String id, @RequestBody Places place){
        Preconditions.checkNotNull(id,place);
        final Places update = updatePlaceDetailsService.update(id, place);
        if(id==null || place==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(update,HttpStatus.OK);
    }

    @DeleteMapping("deletePlaceById")
    public ResponseEntity deletePlaceById(@RequestParam String id) {
        Preconditions.checkNotNull(id);
        if (id == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        final Places placeById = placesService.getById(id);
        if (placeById == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            placesService.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
    }

}
