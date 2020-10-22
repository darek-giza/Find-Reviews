package pl.com.dariusz.giza.FindReviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepositoryCustom;

import java.util.List;


@Service
public class FindByCityServiceImpl implements FindByCityService {

    private PlacesRepositoryCustom placesRepositoryCustom;

    @Autowired
    public FindByCityServiceImpl(PlacesRepositoryCustom placesRepositoryCustom) {
        this.placesRepositoryCustom = placesRepositoryCustom;
    }

    public FindByCityServiceImpl() {
    }

    @Override
    public List<Places> findByCity(String city) {
        if (city == null) {
            throw new IllegalArgumentException("City can't be null value");
        }
        return placesRepositoryCustom.findByCityAndSortByName(city);
    }
}
