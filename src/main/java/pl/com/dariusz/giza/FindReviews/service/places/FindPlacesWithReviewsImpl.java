package pl.com.dariusz.giza.FindReviews.service.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;


@Service
public class FindPlacesWithReviewsImpl implements FindPlacesWithReviews {

    private PlacesRepository placesRepository;

    @Autowired
    public FindPlacesWithReviewsImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public List findPlacesWithReviews() {
        return placesRepository.findPlacesByReviewsIsNotNull();
    }
}
