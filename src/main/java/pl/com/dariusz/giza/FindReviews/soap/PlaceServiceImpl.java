package pl.com.dariusz.giza.FindReviews.soap;

import org.springframework.stereotype.Service;
import pl.com.dariusz.giza.FindReviews.mapper.PlaceMapper;
import pl.com.dariusz.giza.FindReviews.model.Places;
import pl.com.dariusz.giza.FindReviews.service.PlacesService;
import pl.com.dariusz.giza.FindReviews.soap.getplace.Place;

@Service
public class PlaceServiceImpl implements PlaceService {

    private PlacesService placesService;
    private PlaceMapper placeMapper;

    public PlaceServiceImpl(PlacesService placesService, PlaceMapper placeMapper) {
        this.placesService = placesService;
        this.placeMapper = placeMapper;
    }

    @Override
    public Place getPlace(String id) {
        final Places placesById = placesService.getById(id);
        final Place place = placeMapper.convertPlacesToPlace(placesById);
        return place;
    }
}
