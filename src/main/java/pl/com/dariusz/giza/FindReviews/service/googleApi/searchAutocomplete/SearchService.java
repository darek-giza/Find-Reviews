package pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete;

import pl.com.dariusz.giza.FindReviews.model.googleApi.searchPlace.Example;

import java.io.IOException;

public interface SearchService {

    Example search(String input) throws IOException;
}
