package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesService;

import pl.com.dariusz.giza.FindReviews.model.googleApiModels.details.Details;

import java.io.IOException;
import java.util.Set;

public interface FindService {

    Set<Details> findPlacesDetails(String city, String types) throws IOException;
}
