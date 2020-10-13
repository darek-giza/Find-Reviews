package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType.FindParsedData;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType.FindService;

import java.io.IOException;
import java.util.Set;

@RestController
public class FindPlacesController {

    private final PlacesRepository placesRepository;
    private final FindService findService;
    private final FindParsedData findParsedData;

    @Autowired
    public FindPlacesController(PlacesRepository placesRepository, FindService findService, FindParsedData findParsedData) {
        this.placesRepository = placesRepository;
        this.findService = findService;
        this.findParsedData = findParsedData;
    }


    @GetMapping("/find")
    public Set<Details> find(@RequestParam String city, @RequestParam String types) throws IOException {
        return findService.findPlacesDetails(city, types);
    }
    // types used by Google Places API ( https://developers.google.com/places/supported_types )
    // endpoint gives response from google api


    @GetMapping("/fill-DB")
    public Set<Places> getParsedData(@RequestParam String city, @RequestParam String types) throws IOException {
        final Set<Places> parse = findParsedData.parse(city, types);
        placesRepository.saveAll(parse);
        return parse;
    }
    // endpoint gives response with parsed data
}

