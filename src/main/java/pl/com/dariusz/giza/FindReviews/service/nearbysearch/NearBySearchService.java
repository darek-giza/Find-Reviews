package pl.com.dariusz.giza.FindReviews.service.nearbysearch;

import pl.com.dariusz.giza.FindReviews.model.nearBySearch.Example;

import java.io.IOException;

public interface NearBySearchService {

    Example nearbysearch(String types, double lat, double lng, int radius, String keywords,
                         String language, Integer minprice, String name, Boolean opennow) throws IOException;
}
