package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService.FindParsedDataService;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService.FindService;

import java.io.IOException;
import java.util.Set;

@RestController
public class FindPlacesController {

    private final PlacesRepository placesRepository;
    private final FindService findService;
    private final FindParsedDataService findParsedDataService;

    @Autowired
    public FindPlacesController(PlacesRepository placesRepository, FindService findService, FindParsedDataService findParsedDataService) {
        this.placesRepository = placesRepository;
        this.findService = findService;
        this.findParsedDataService = findParsedDataService;
    }


    @GetMapping("/find")
    public Set<Details> find(@RequestParam String city, @RequestParam String types) throws IOException {
        return findService.findPlacesDetails(city, types);
    }
    // types used by Google Places API ( https://developers.google.com/places/supported_types )
    // endpoint gives response from google api


    @GetMapping("/fill-DB")
    public Set<Places> getParsedData(@RequestParam String city, @RequestParam String types) throws IOException {
        final Set<Places> parse = findParsedDataService.parse(city, types);
        findParsedDataService.save(parse);
        return parse;
    }
    // endpoint gives response with parsed data
}

