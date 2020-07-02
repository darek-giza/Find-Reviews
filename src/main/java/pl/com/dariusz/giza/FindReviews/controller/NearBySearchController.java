package pl.com.dariusz.giza.FindReviews.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.model.nearBySearch.Example;
import pl.com.dariusz.giza.FindReviews.service.nearbysearch.NearBySearchService;

import java.io.IOException;

@RestController
public class NearBySearchController {

    private final NearBySearchService nearBySearchService;

    @Autowired
    public NearBySearchController(NearBySearchService nearBySearchService) {
        this.nearBySearchService = nearBySearchService;
    }

    @GetMapping("/nearbysearch")
    public Example nearBySearch() throws IOException {
        return nearBySearchService.nearbysearch("hotel", 51.503962, -0.155331, 10000, ""
                , "", null, "", null);
    }
}
