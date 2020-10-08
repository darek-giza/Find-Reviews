package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import pl.com.dariusz.giza.FindReviews.model.googleApi.details.Details;
import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.DetailsDTO;

import java.io.IOException;
import java.util.Set;

public interface FindService {

    Set<DetailsDTO> findPlacesDetails(String city, String types) throws IOException;
}
