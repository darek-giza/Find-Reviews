package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.nearbySearch.NearbyPlaces;
import pl.com.dariusz.giza.FindReviews.service.nearbysearch.NearbySearchService;

import java.io.IOException;

@RestController
public class NearbySearchController {

    private final NearbySearchService nearBySearchService;

    @Autowired
    public NearbySearchController(NearbySearchService nearBySearchService) {
        this.nearBySearchService = nearBySearchService;
    }

    @GetMapping("/nearbysearch")
    public NearbyPlaces nearBySearch() throws IOException {
        return nearBySearchService.nearbysearch("hotel", 51.3308, 21.9392, 10000, ""
                , "", null, "", null);
    }
}
