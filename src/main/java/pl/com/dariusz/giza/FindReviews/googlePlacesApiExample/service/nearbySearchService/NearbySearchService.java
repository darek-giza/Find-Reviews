package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.service.nearbySearchService;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.nearbySearch.NearbyPlaces;

import java.io.IOException;

public interface NearbySearchService {

    NearbyPlaces search(String types, Double latitude, Double longitude, Integer radius,
                        String keywords, String language, Integer minprice, String name, Boolean opennow) throws IOException;
}
