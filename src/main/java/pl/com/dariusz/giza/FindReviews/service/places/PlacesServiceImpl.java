package pl.com.dariusz.giza.FindReviews.service.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.List;

@Service
public class PlacesServiceImpl implements PlacesService {

    private PlacesRepository placesRepository;

    @Autowired
    public PlacesServiceImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public List<Places> getAll() {
        return placesRepository.findAll();
    }

    @Override
    public List<Places> save(List<Places> placesList) {
        return placesRepository.saveAll(placesList);
    }

    @Override
    public void delete(String id) {
        placesRepository.deleteById(id);
    }
}
