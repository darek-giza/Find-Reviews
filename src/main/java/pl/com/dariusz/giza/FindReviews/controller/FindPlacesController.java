package pl.com.dariusz.giza.FindReviews.controller;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService.FindParsedDataService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService.FindService;

import java.io.IOException;
import java.util.Set;

@RestController
public class FindPlacesController {

    private final FindService findService;
    private final FindParsedDataService findParsedDataService;

    @Autowired
    public FindPlacesController(FindService findService, FindParsedDataService findParsedDataService) {
        this.findService = findService;
        this.findParsedDataService = findParsedDataService;
    }


    @GetMapping("/find")
    public ResponseEntity<Set<Details>> find(@RequestParam String city, @RequestParam String types) throws IOException {
        Preconditions.checkNotNull(city, types);
        final Set<Details> placesDetails = findService.findPlacesDetails(city, types);
        if (placesDetails == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(placesDetails, HttpStatus.OK);
    }
    // types used by Google Places API ( https://developers.google.com/places/supported_types )
    // endpoint gives response from google api


    @GetMapping("/fill-DB")
    public ResponseEntity<Set<Places>> getParsedData(@RequestParam String city, @RequestParam String types) throws IOException {
        Preconditions.checkNotNull(city, types);
        final Set<Places> parse = findParsedDataService.parse(city, types);
        if (parse == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        findParsedDataService.save(parse);
        return new ResponseEntity<>(parse, HttpStatus.OK);
    }
    // endpoint gives response with parsed data
}

