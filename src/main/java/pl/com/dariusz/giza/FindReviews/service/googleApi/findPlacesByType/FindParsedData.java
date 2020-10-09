package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import pl.com.dariusz.giza.FindReviews.model.googleApi.detailsDTO.DetailsDTO;

import java.io.IOException;
import java.util.Set;

public interface FindParsedData {

    Set<DetailsDTO> parse(String city, String types) throws IOException;
}
