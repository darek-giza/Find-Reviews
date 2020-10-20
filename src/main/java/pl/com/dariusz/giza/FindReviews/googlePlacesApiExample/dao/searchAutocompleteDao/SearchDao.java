package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.searchAutocompleteDao;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.searchPlace.Example;

import java.io.IOException;

public interface SearchDao {

    Example search(String input) throws IOException;
}
