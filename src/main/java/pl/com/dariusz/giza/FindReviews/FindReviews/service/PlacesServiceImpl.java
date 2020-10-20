package pl.com.dariusz.giza.FindReviews.FindReviews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.FindReviews.repositories.PlacesRepository;

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
    public Places getById(String id) {
        return placesRepository.findById(id).get();
    }

    @Override
    public void delete(String id) {
        placesRepository.deleteById(id);
    }
}
