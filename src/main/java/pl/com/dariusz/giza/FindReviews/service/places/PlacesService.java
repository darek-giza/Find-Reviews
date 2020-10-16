package pl.com.dariusz.giza.FindReviews.service.places;

import pl.com.dariusz.giza.FindReviews.model.places.Places;

import java.util.*;

public interface PlacesService {

    List<Places> getAll();

    List<Places> save(List<Places> placesList);

    Places getById(String id);

    void delete(String id);
}
