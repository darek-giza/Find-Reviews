package pl.com.dariusz.giza.googlePlacesApiExample.service.searchService;

import pl.com.dariusz.giza.googlePlacesApiExample.model.searchPlace.Example;

import java.io.IOException;

public interface SearchService {

    Example get(String input) throws IOException;
}
