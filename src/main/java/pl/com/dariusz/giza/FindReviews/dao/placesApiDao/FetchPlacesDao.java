package pl.com.dariusz.giza.FindReviews.dao.placesApiDao;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.details.Details;

import java.io.IOException;
import java.util.Set;

public interface FetchPlacesDao {

    Set<Details> fetchPlacesDetails(String city, String types) throws IOException;
}
