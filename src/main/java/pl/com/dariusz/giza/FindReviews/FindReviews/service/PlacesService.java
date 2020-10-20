package pl.com.dariusz.giza.FindReviews.FindReviews.service;

import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;

import java.util.List;

public interface PlacesService {

    List<Places> getAll();

    List<Places> save(List<Places> placesList);

    Places getById(String id);

    void delete(String id);
}
