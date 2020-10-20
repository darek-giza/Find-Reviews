package pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.dao.nearbySearchDao;

import pl.com.dariusz.giza.FindReviews.googlePlacesApiExample.model.nearbySearch.NearbyPlaces;

import java.io.IOException;

public interface NearbySearchDao {

    NearbyPlaces nearbySearch(String types, Double lat, Double lng, int radius, String keywords,
                              String language, Integer minprice, String name, Boolean opennow) throws IOException;
}
