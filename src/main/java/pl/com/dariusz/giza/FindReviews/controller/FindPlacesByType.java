package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;
import pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType.FindService;

import java.io.IOException;
import java.util.Set;

@RestController
public class FindPlacesByType {

    private final FindService findService;

    @Autowired
    public FindPlacesByType(FindService findService) {
        this.findService = findService;
    }

    @GetMapping("/findPlacesByType")
    public Set<Details> find(@RequestParam String city, @RequestParam String types) throws IOException {
        return findService.findPlacesDetails(city, types);
    }
    // types used by Google Places API ( https://developers.google.com/places/supported_types )
}

