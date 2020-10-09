package pl.com.dariusz.giza.FindReviews.service.googleApi.findPlacesByType;

import pl.com.dariusz.giza.FindReviews.model.places.Places;

import java.io.IOException;
import java.util.Set;

public interface FindParsedData {

    Set<Places> parse(String city, String types) throws IOException;
}
