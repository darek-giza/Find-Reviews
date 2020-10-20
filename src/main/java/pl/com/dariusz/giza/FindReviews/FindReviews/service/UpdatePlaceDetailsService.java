package pl.com.dariusz.giza.FindReviews.FindReviews.service;

import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;

public interface UpdatePlaceDetailsService {

    Places update(String id, Places places);
}
