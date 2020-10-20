package pl.com.dariusz.giza.FindReviews.service;

import pl.com.dariusz.giza.FindReviews.model.Places;

public interface UpdatePlaceDetailsService {

    Places update(String id, Places places);
}
