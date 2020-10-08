package pl.com.dariusz.giza.FindReviews.controller.googleApiTestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete.SearchService;

import java.io.IOException;

@RestController
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public pl.com.dariusz.giza.FindReviews.model.googleApi.searchPlace.Example search() throws IOException {
        return searchService.search("War");
    }

}