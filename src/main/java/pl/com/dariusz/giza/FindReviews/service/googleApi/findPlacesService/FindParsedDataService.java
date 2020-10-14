package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService;

import pl.com.dariusz.giza.FindReviews.model.places.Places;

import java.io.IOException;
import java.util.Set;

public interface FindParsedDataService {

    Set<Places> parse(String city, String types) throws IOException;

    void save(Set<Places> placesSet);
}
