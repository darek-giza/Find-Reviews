package pl.com.dariusz.giza.FindReviews.service.places;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.model.places.Places;
import pl.com.dariusz.giza.FindReviews.repositories.PlacesRepository;

import java.util.Optional;

@Service
public class UpdatePlaceDetailsImpl implements UpdatePlaceDetails {

    private PlacesRepository placesRepository;

    @Autowired
    public UpdatePlaceDetailsImpl(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public Places update(String id, Places places) {
        final Optional<Places> placeById = placesRepository.findById(id);

        placeById.ifPresent(p -> {
            p.setFormattedAddress(places.getFormattedAddress());
            p.setFormattedPhoneNumber(places.getFormattedPhoneNumber());
            p.setPlaceId(places.getPlaceId());
            p.setName(places.getName());
            p.setTypes(places.getTypes());
            p.setUrl(places.getUrl());
            p.setWebsite(places.getWebsite());
            p.setReviews(places.getReviews());
        });

        return placesRepository.save(placeById.orElseThrow());

    }
}
