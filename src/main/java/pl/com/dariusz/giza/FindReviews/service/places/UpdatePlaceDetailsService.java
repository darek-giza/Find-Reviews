package pl.com.dariusz.giza.FindReviews.service.places;

import pl.com.dariusz.giza.FindReviews.model.places.Places;

public interface UpdatePlaceDetailsService {

    Places update(String id, Places places);
}
