package pl.com.dariusz.giza.FindReviews.service.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;


@Service
public class FindByCityImpl implements FindByCity {

    private PlacesRepository placesRepository;

    @Autowired
    public FindByCityImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    public FindByCityImpl() {

    }

    @Override
    public List findByCity(String city) {
        if(city == null){
            throw new IllegalArgumentException("City can't be null value");
        }
        return placesRepository.findByFormattedAddressIsContaining(city);
    }
}
