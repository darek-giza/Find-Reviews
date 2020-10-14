package pl.com.dariusz.giza.FindReviews.service.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;


@Service
public class FindPlacesWithReviewsServiceImpl implements FindPlacesWithReviewsService {

    private PlacesRepository placesRepository;

    @Autowired
    public FindPlacesWithReviewsServiceImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public List findPlacesWithReviews() {
        return placesRepository.findPlacesByReviewsIsNotNull();
    }
}
