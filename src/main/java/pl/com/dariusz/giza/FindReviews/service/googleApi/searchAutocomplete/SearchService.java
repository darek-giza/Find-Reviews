package pl.com.dariusz.giza.FindReviews.service.googleApi.searchAutocomplete;

import pl.com.dariusz.giza.FindReviews.model.googleApiModels.searchPlace.Example;

import java.io.IOException;

public interface SearchService {

    Example search(String input) throws IOException;
}
