package pl.com.dariusz.giza.FindReviews.service.googleApi.nearbysearch;

import pl.com.dariusz.giza.FindReviews.model.googleApiModels.nearbySearch.NearbyPlaces;

import java.io.IOException;

public interface NearbySearchService {

    NearbyPlaces nearbysearch(String types, double lat, double lng, int radius, String keywords,
                              String language, Integer minprice, String name, Boolean opennow) throws IOException;
}
