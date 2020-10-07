package pl.com.dariusz.giza.FindReviews.service.googleApi.details;

import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;

import java.io.IOException;
import java.util.Set;

public interface DetailsService {

    Details getDetails(String place_id) throws IOException;

    Set<Details> getAllPlacesDetails(Set<String> id) throws IOException;
}
