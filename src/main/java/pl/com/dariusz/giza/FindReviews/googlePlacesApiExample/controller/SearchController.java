package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.searchPlace.Example;
import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.searchService.SearchService;

import java.io.IOException;

@RestController
public class SearchController {

    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/search")
    public ResponseEntity<Example> search() throws IOException {
        final Example items = searchService.get("War");
        if (items == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }
}
