package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.searchService;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.searchPlace.Example;

import java.io.IOException;

public interface SearchService {

    Example get(String input) throws IOException;
}
