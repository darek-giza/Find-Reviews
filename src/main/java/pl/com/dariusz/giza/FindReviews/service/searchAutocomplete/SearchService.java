package pl.com.dariusz.giza.FindReviews.service.searchAutocomplete;

import pl.com.dariusz.giza.FindReviews.model.searchPlace.Example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public interface SearchService {

    Example search(String input) throws IOException;
}
